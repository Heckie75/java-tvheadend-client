package de.heckie.tvheadend.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.heckie.tvheadend.api.model.KeyValList;
import de.heckie.tvheadend.api.model.channel.BouquetGrid;
import de.heckie.tvheadend.api.model.channel.ChannelGrid;
import de.heckie.tvheadend.api.model.channel.ChannelTagGrid;
import de.heckie.tvheadend.api.model.dvr.AutoRecEntry;
import de.heckie.tvheadend.api.model.dvr.AutoRecEntryGrid;
import de.heckie.tvheadend.api.model.dvr.DvrEntry;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGrid;
import de.heckie.tvheadend.api.model.dvr.TimeRecEntry;
import de.heckie.tvheadend.api.model.dvr.TimeRecEntryGrid;
import de.heckie.tvheadend.api.model.epg.Event;
import de.heckie.tvheadend.api.model.epg.EventGrid;
import de.heckie.tvheadend.api.model.status.ConnectionGrid;
import de.heckie.tvheadend.api.model.status.InputGrid;
import de.heckie.tvheadend.api.model.status.SubscriptionGrid;

public class TvheadendHttpClient {

  private final static String API_BOUGUET_GRID = "/api/bouquet/grid";

  private final static String API_CHANNEL_CATEGORY_LIST = "/api/channelcategory/list";
  private final static String API_CHANNEL_GRID = "/api/channel/grid";
  private final static String API_CHANNEL_LIST = "/api/channel/list";
  private final static String API_CHANNEL_TAG_LIST = "/api/channeltag/list";
  private final static String API_CHANNEL_TAG_GRID = "/api/channeltag/grid";

  private final static String API_CONFIG_CAPABILITIES = "/api/config/capabilities";

  private final static String API_DVR_AUTOREC_CREATE = "/api/dvr/autorec/create";
  private final static String API_DVR_AUTOREC_GRID = "/api/dvr/autorec/grid";
  private final static String API_DVR_ENTRY_CREATE = "/api/dvr/entry/create";
  private final static String API_DVR_ENTRY_CREATE_BY_EVENT = "/api/dvr/entry/create_by_event";
  private final static String API_DVR_AUTOREC_CREATE_BY_SERIES = "/api/dvr/autorec/create_by_series";
  private final static String API_DVR_ENTRY_GRID_FAILED = "/api/dvr/entry/grid_failed";
  private final static String API_DVR_ENTRY_GRID_FINISHED = "/api/dvr/entry/grid_finished";
  private final static String API_DVR_ENTRY_GRID_UPCOMING = "/api/dvr/entry/grid_upcoming";
  private final static String API_DVR_ENTRY_GRID_REMOVED = "/api/dvr/entry/grid_removed";
  private final static String API_DVR_TIMEREC_CREATE = "/api/dvr/timerec/create";
  private final static String API_DVR_TIMEREC_GRID = "/api/dvr/timerec/grid";

  private final static String API_EPG_CONTENT_TYPE_LIST = "/api/epg/content_type/list";
  private final static String API_EPG_EVENTS_GRID = "/api/epg/events/grid";

  private final static String API_IDNODE_DELETE = "/api/idnode/delete";
  private final static String API_IDNODE_LOAD = "/api/idnode/load";
  private final static String API_IDNODE_SAVE = "/api/idnode/save";

  private final static String API_STATUS_INPUTS = "/api/status/inputs";
  private final static String API_STATUS_SUBSCRIPTIONS = "/api/status/subscriptions";
  private final static String API_STATUS_CONNECTIONS = "/api/status/connections";

  public final static String DVR_DEFAULT_PROFILE = "(Default profile)";

  public final static String ID_NODE_CLASS_DVR_CONFIG = "dvrconfig";

  private final HttpHost target;
  private final HttpClientContext localContext;
  private final CredentialsProvider credsProvider;

  private Map<String, Object> cache;

  private static String getParamsAsJson(Object object) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      // no op
    }
    return null;
  }

  public TvheadendHttpClient(String uri, String user, String password)
      throws IOException, MalformedURLException, MalformedChallengeException {

    this.cache = new HashMap<>();

    URL url = new URL(uri);
    target = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
    if (target == null) {
      throw new MalformedURLException("Setup URI was unsuccesfull");
    }

    Header challengeHeader = getAuthChallengeHeader(uri);

    this.credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(
        new AuthScope(target.getHostName(), target.getPort()),
        new UsernamePasswordCredentials(user, password));

    AuthCache authCache = new BasicAuthCache();
    DigestScheme digestAuth = new DigestScheme();
    digestAuth.processChallenge(challengeHeader);
    authCache.put(target, digestAuth);
    this.localContext = HttpClientContext.create();
    localContext.setAuthCache(authCache);
  }

  private Header getAuthChallengeHeader(String uri) throws IOException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      CloseableHttpResponse response = httpClient.execute(new HttpGet(uri));
      Header challengeHeader = response.getFirstHeader("WWW-Authenticate");
      if (challengeHeader == null) {
        throw new IOException("Could not connect and get WWW-Authenticate header from given URI.");
      }
      return challengeHeader;
    } catch (IOException e) {
      throw e;
    }
  }

  private <T> T post(String request, Map<String, String> params, Class<T> clazz)
      throws IOException {

    try (CloseableHttpClient httpclient = HttpClients.custom()
        .setDefaultCredentialsProvider(credsProvider)
        .build()) {

      HttpPost post = new HttpPost(request);
      if (params != null) {
        List<BasicNameValuePair> nameValuePair = params.entrySet().stream()
            .map(e -> new BasicNameValuePair(e.getKey(), e.getValue())).collect(Collectors.toList());
        post.setEntity(new UrlEncodedFormEntity(nameValuePair));
      }

      try (CloseableHttpResponse response = httpclient
          .execute(target, post, localContext)) {

        return new ObjectMapper().readValue(
            EntityUtils.toString(response.getEntity()),
            clazz);
      }
    }
  }

  private <T> T postFreshOrFromCache(String request, Map<String, String> params, String cacheKey, boolean force, Class<T> clazz)
      throws IOException {

    T value;
    if (force || !cache.containsKey(cacheKey)) {
      value = post(request, params, clazz);
      cache.put(cacheKey, value);
    } else {
      value = (T) cache.get(cacheKey);
    }
    return value;

  }

  public List<String> getCapabilities(boolean force) throws IOException {
    return postFreshOrFromCache(API_CONFIG_CAPABILITIES, null, API_CONFIG_CAPABILITIES, force, ArrayList.class);
  }

  public EventGrid getEvents(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "start", "0",
        "limit", "9999999",
        "sort", "start",
        "direction", "date",
        "mode", "all");

    return postFreshOrFromCache(API_EPG_EVENTS_GRID, params, API_EPG_EVENTS_GRID, force, EventGrid.class);
  }

  public List<Event> getEvents(boolean force, List<String> channelUuids, long from, long to) throws IOException {
    return getEvents(force).getEntries().stream().filter(
        e -> (channelUuids == null || channelUuids.contains(e.getChannelUuid())) && e.getStart() * 1000 >= from
            && e.getStart() * 1000 < to)
        .collect(Collectors.toList());
  }

  public KeyValList getGenreTypes(boolean force) throws IOException {
    return postFreshOrFromCache(API_EPG_CONTENT_TYPE_LIST, null, API_EPG_CONTENT_TYPE_LIST, force, KeyValList.class);
  }

  public KeyValList getChannelTagList(boolean force) throws IOException {
    return postFreshOrFromCache(API_CHANNEL_TAG_LIST, null, API_CHANNEL_TAG_LIST, force, KeyValList.class);
  }

  public ChannelTagGrid getChannelTagGrid(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "all", "1",
        "dir", "asc",
        "sort", "name");
    return postFreshOrFromCache(API_CHANNEL_TAG_GRID, params, API_CHANNEL_TAG_GRID, force, ChannelTagGrid.class);
  }

  public KeyValList getChannelCategoryList(boolean force) throws IOException {
    return postFreshOrFromCache(API_CHANNEL_CATEGORY_LIST, null, API_CHANNEL_CATEGORY_LIST, force, KeyValList.class);
  }

  public ChannelGrid getChannelGrid(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "all", "1",
        "start", "0",
        "limit", "999999",
        "dir", "asc",
        "sort", "number");
    return postFreshOrFromCache(API_CHANNEL_GRID, params, API_CHANNEL_GRID, force, ChannelGrid.class);
  }

  public KeyValList getChannelList(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "all", "1",
        "numbers", "0");
    return postFreshOrFromCache(API_CHANNEL_LIST, params, API_CHANNEL_LIST, force, KeyValList.class);
  }

  public BouquetGrid getBouquetGrid(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "dir", "asc",
        "sort", "name");
    return postFreshOrFromCache(API_BOUGUET_GRID, params, API_BOUGUET_GRID, force, BouquetGrid.class);
  }

  public String getDvrDefaultConfig(boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "enum", "1",
        "class", ID_NODE_CLASS_DVR_CONFIG);
    KeyValList idNode = getIdNode(params, ID_NODE_CLASS_DVR_CONFIG, force);
    return idNode.getByVal(DVR_DEFAULT_PROFILE).getKey();
  }

  private List<String> createDvrEntryByEventOrSeries(String api, long eventId, String configUuid) throws IOException {

    if (configUuid == null || configUuid.isBlank()) {
      configUuid = getDvrDefaultConfig(false);
    }
    Map<String, String> params = Map.of(
        "config_uuid", configUuid,
        "event_id", String.valueOf(eventId));
    Map<String, List<String>> response = post(api, params, Map.class);
    return response.get("uuid");
  }

  public List<String> createDvrEntryByEvent(long eventId, String configUuid) throws IOException {
    List<String> createDvrEntryByEventOrSeries = createDvrEntryByEventOrSeries(API_DVR_ENTRY_CREATE_BY_EVENT, eventId,
        configUuid);
    return createDvrEntryByEventOrSeries;
  }

  public List<String> createDvrAutoRecByEvent(long eventId, String configUuid) throws IOException {
    return createDvrEntryByEventOrSeries(API_DVR_AUTOREC_CREATE_BY_SERIES, eventId, configUuid);
  }

  public String createDvrEntry(DvrEntry dvrEntry) throws IOException {
    String json = getParamsAsJson(dvrEntry);
    Map<String, String> response = post(API_DVR_ENTRY_CREATE, Map.of("conf", json), Map.class);
    return response.get("uuid");
  }

  private DvrEntryGrid getDvrEntryList(String request, boolean force) throws IOException {
    Map<String, String> params = Map.of(
        "start", "0",
        "limit", "999999",
        "dir", "DESC",
        "sort", "start_real");
    return postFreshOrFromCache(request, params, request, force, DvrEntryGrid.class);
  }

  public DvrEntryGrid getUpcomingDvrEntryList(boolean force) throws IOException {
    return getDvrEntryList(API_DVR_ENTRY_GRID_UPCOMING, force);
  }

  public DvrEntryGrid getFinishedDvrEntryList(boolean force) throws IOException {
    return getDvrEntryList(API_DVR_ENTRY_GRID_FINISHED, force);
  }

  public DvrEntryGrid getFailedDvrEntryList(boolean force) throws IOException {
    return getDvrEntryList(API_DVR_ENTRY_GRID_FAILED, force);
  }

  public DvrEntryGrid getRemovedDvrEntryList(boolean force) throws IOException {
    return getDvrEntryList(API_DVR_ENTRY_GRID_REMOVED, force);
  }

  public Collection<DvrEntry> getAllDvrEntries(boolean force) throws IOException {
    List<DvrEntry> entries = new ArrayList<>();
    entries.addAll(getUpcomingDvrEntryList(force).getEntries());
    entries.addAll(getFinishedDvrEntryList(force).getEntries());
    entries.addAll(getFailedDvrEntryList(force).getEntries());
    entries.addAll(getRemovedDvrEntryList(force).getEntries());
    return Collections.unmodifiableCollection(entries);
  }

  public String createAutoRecEntry(AutoRecEntry autoRecEntry) throws IOException {
    String json = getParamsAsJson(autoRecEntry);
    Map<String, String> response = post(API_DVR_AUTOREC_CREATE, Map.of("conf", json), Map.class);
    return response.get("uuid");
  }

  public AutoRecEntryGrid getAutoRecEntryList(boolean force) throws IOException {
    return postFreshOrFromCache(API_DVR_AUTOREC_GRID, null, API_DVR_AUTOREC_GRID, force, AutoRecEntryGrid.class);
  }

  public String createTimeRecEntry(TimeRecEntry timeRecEntry) throws IOException {
    String json = getParamsAsJson(timeRecEntry);
    Map<String, String> response = post(API_DVR_TIMEREC_CREATE, Map.of("conf", json), Map.class);
    return response.get("uuid");
  }

  public TimeRecEntryGrid getTimeRecEntryList(boolean force) throws IOException {
    return postFreshOrFromCache(API_DVR_TIMEREC_GRID, null, API_DVR_TIMEREC_GRID, force, TimeRecEntryGrid.class);
  }

  public InputGrid getInputGrid(boolean force) throws IOException {
    return postFreshOrFromCache(API_STATUS_INPUTS, null, API_STATUS_INPUTS, force, InputGrid.class);
  }

  public SubscriptionGrid getSubscriptionGrid(boolean force) throws IOException {
    return postFreshOrFromCache(API_STATUS_SUBSCRIPTIONS, null, API_STATUS_SUBSCRIPTIONS, force, SubscriptionGrid.class);
  }

  public ConnectionGrid getConnectionGrid(boolean force) throws IOException {
    return postFreshOrFromCache(API_STATUS_CONNECTIONS, null, API_STATUS_CONNECTIONS, force, ConnectionGrid.class);
  }

  private KeyValList getIdNode(Map<String, String> params, String cacheKey, boolean force) throws IOException {
    return postFreshOrFromCache(API_IDNODE_LOAD, params, cacheKey, force, KeyValList.class);
  }

  public void saveAutoRecEntry(AutoRecEntry a) throws IOException {
    AutoRecEntry updateItem = AutoRecEntry.of(a);
    String json = getParamsAsJson(updateItem);
    post(API_IDNODE_SAVE, Map.of("node", json), Object.class);
  }

  public void saveTimeRecEntry(TimeRecEntry t) throws IOException {
    TimeRecEntry updateItem = TimeRecEntry.of(t);
    String json = getParamsAsJson(updateItem);
    post(API_IDNODE_SAVE, Map.of("node", json), Object.class);
  }

  public void saveDvrEntry(DvrEntry d) throws IOException {
    DvrEntry updateItem = DvrEntry.of(d);
    String json = getParamsAsJson(updateItem);
    post(API_IDNODE_SAVE, Map.of("node", json), Object.class);
  }

  public void deleteIdNode(String[] uuidsOfSameEntity) throws IOException {
    String json = getParamsAsJson(uuidsOfSameEntity);
    post(API_IDNODE_DELETE, Map.of("uuid", json), Object.class);
  }

}