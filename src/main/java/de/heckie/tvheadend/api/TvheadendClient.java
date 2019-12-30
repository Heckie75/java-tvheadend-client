package de.heckie.tvheadend.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import de.heckie.tvheadend.api.model.AbstractParams;
import de.heckie.tvheadend.api.model.KeyValList;
import de.heckie.tvheadend.api.model.WrapParameter;
import de.heckie.tvheadend.api.model.channel.BouquetGrid;
import de.heckie.tvheadend.api.model.channel.BouquetGridRequestParameter;
import de.heckie.tvheadend.api.model.channel.ChannelGrid;
import de.heckie.tvheadend.api.model.channel.ChannelGridRequestParameter;
import de.heckie.tvheadend.api.model.channel.ChannelListRequestParameter;
import de.heckie.tvheadend.api.model.channel.ChannelTagGrid;
import de.heckie.tvheadend.api.model.channel.ChannelTagGridRequestParameter;
import de.heckie.tvheadend.api.model.dvr.AutoRecEntry;
import de.heckie.tvheadend.api.model.dvr.AutoRecEntryGrid;
import de.heckie.tvheadend.api.model.dvr.DvrEntry;
import de.heckie.tvheadend.api.model.dvr.DvrEntryByEventRequestParameter;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGrid;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGridRequestParameter;
import de.heckie.tvheadend.api.model.dvr.TimeRecEntry;
import de.heckie.tvheadend.api.model.dvr.TimeRecEntryGrid;
import de.heckie.tvheadend.api.model.epg.EventGrid;
import de.heckie.tvheadend.api.model.epg.EventRequestParameter;
import de.heckie.tvheadend.api.model.idnode.IdNodeRequestParameter;
import de.heckie.tvheadend.api.model.status.ConnectionGrid;
import de.heckie.tvheadend.api.model.status.InputGrid;
import de.heckie.tvheadend.api.model.status.SubscriptionGrid;

public class TvheadendClient {

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

  public TvheadendClient(String uri, String user, String password)
      throws IOException, MalformedURLException, MalformedChallengeException {
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

  private <T> T post(String request, AbstractParams params, Class<T> clazz)
      throws IOException {

    try (CloseableHttpClient httpclient = HttpClients.custom()
        .setDefaultCredentialsProvider(credsProvider)
        .build()) {

      HttpPost post = new HttpPost(request);
      if (params != null) {
        List<BasicNameValuePair> nameValuePair = params.toMap().entrySet().stream().filter(e -> !e.getValue().isBlank())
            .map(e -> new BasicNameValuePair(e.getKey(), String.valueOf(e.getValue()))).collect(Collectors.toList());
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

  public List<String> getCapabilities() throws IOException {
    return post(API_CONFIG_CAPABILITIES, null, ArrayList.class);
  }

  public EventGrid getEvents(EventRequestParameter eventRequestParameter) throws IOException {
    if (eventRequestParameter == null) {
      eventRequestParameter = new EventRequestParameter();
    }
    return post(API_EPG_EVENTS_GRID, eventRequestParameter, EventGrid.class);
  }

  public KeyValList getGenreTypes() throws IOException {
    return post(API_EPG_CONTENT_TYPE_LIST, null, KeyValList.class);
  }

  public KeyValList getChannelTagList() throws IOException {
    return post(API_CHANNEL_TAG_LIST, null, KeyValList.class);
  }

  public ChannelTagGrid getChannelTagGrid(ChannelTagGridRequestParameter channelTagGridRequestParameter) throws IOException {
    if (channelTagGridRequestParameter == null) {
      channelTagGridRequestParameter = new ChannelTagGridRequestParameter();
    }
    return post(API_CHANNEL_TAG_GRID, channelTagGridRequestParameter, ChannelTagGrid.class);
  }

  public KeyValList getChannelCategoryList() throws IOException {
    return post(API_CHANNEL_CATEGORY_LIST, null, KeyValList.class);
  }

  public ChannelGrid getChannelGrid(ChannelGridRequestParameter channelGridRequestParameter) throws IOException {
    if (channelGridRequestParameter == null) {
      channelGridRequestParameter = new ChannelGridRequestParameter();
    }
    return post(API_CHANNEL_GRID, channelGridRequestParameter, ChannelGrid.class);
  }

  public KeyValList getChannelList(ChannelListRequestParameter channelListRequestParameter) throws IOException {
    if (channelListRequestParameter == null) {
      channelListRequestParameter = new ChannelListRequestParameter();
    }
    return post(API_CHANNEL_LIST, channelListRequestParameter, KeyValList.class);
  }

  public BouquetGrid getBouquetGrid(BouquetGridRequestParameter bouquetGridRequestParameter) throws IOException {
    if (bouquetGridRequestParameter == null) {
      bouquetGridRequestParameter = new BouquetGridRequestParameter();
    }
    return post(API_BOUGUET_GRID, bouquetGridRequestParameter, BouquetGrid.class);
  }

  public String getDvrDefaultConfig() throws IOException {
    IdNodeRequestParameter idNodeRequestParameter = new IdNodeRequestParameter();
    idNodeRequestParameter.setClazz(TvheadendClient.ID_NODE_CLASS_DVR_CONFIG);
    KeyValList idNode = getIdNode(idNodeRequestParameter);
    return idNode.getByVal(DVR_DEFAULT_PROFILE).getKey();
  }

  private List<String> createDvrEntryByEventOrSeries(String api, long eventId, String configUuid) throws IOException {
    DvrEntryByEventRequestParameter dvrEntryByEventRequestParameter = new DvrEntryByEventRequestParameter();
    dvrEntryByEventRequestParameter.setEventId(eventId);
    if (configUuid == null || configUuid.isBlank()) {
      configUuid = getDvrDefaultConfig();
    }
    dvrEntryByEventRequestParameter.setConfigUuid(configUuid);
    Map<String, List<String>> response = post(api, dvrEntryByEventRequestParameter, Map.class);
    return response.get("uuid");
  }

  public List<String> createDvrEntryByEvent(long eventId, String configUuid) throws IOException {
    return createDvrEntryByEventOrSeries(API_DVR_ENTRY_CREATE_BY_EVENT, eventId, configUuid);
  }

  public List<String> createDvrAutoRecByEvent(long eventId, String configUuid) throws IOException {
    return createDvrEntryByEventOrSeries(API_DVR_AUTOREC_CREATE_BY_SERIES, eventId, configUuid);
  }

  public String createDvrEntry(DvrEntry dvrEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("conf", dvrEntry);
    Map<String, String> response = post(API_DVR_ENTRY_CREATE, parameter, Map.class);
    return response.get("uuid");
  }

  public DvrEntryGrid getUpcomingDvrEntryList(DvrEntryGridRequestParameter dvrEntryGridRequestParameter) throws IOException {
    if (dvrEntryGridRequestParameter == null) {
      dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    }
    return post(API_DVR_ENTRY_GRID_UPCOMING, dvrEntryGridRequestParameter, DvrEntryGrid.class);
  }

  public DvrEntryGrid getFinishedDvrEntryList(DvrEntryGridRequestParameter dvrEntryGridRequestParameter) throws IOException {
    if (dvrEntryGridRequestParameter == null) {
      dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    }
    return post(API_DVR_ENTRY_GRID_FINISHED, dvrEntryGridRequestParameter, DvrEntryGrid.class);
  }

  public DvrEntryGrid getFailedDvrEntryList(DvrEntryGridRequestParameter dvrEntryGridRequestParameter) throws IOException {
    if (dvrEntryGridRequestParameter == null) {
      dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    }
    return post(API_DVR_ENTRY_GRID_FAILED, dvrEntryGridRequestParameter, DvrEntryGrid.class);
  }

  public DvrEntryGrid getRemovedDvrEntryList(DvrEntryGridRequestParameter dvrEntryGridRequestParameter) throws IOException {
    if (dvrEntryGridRequestParameter == null) {
      dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    }
    return post(API_DVR_ENTRY_GRID_REMOVED, dvrEntryGridRequestParameter, DvrEntryGrid.class);
  }

  public String createAutoRecEntry(AutoRecEntry autoRecEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("conf", autoRecEntry);
    Map<String, String> response = post(API_DVR_AUTOREC_CREATE, parameter, Map.class);
    return response.get("uuid");
  }

  public AutoRecEntryGrid getAutoRecEntryList() throws IOException {
    return post(API_DVR_AUTOREC_GRID, null, AutoRecEntryGrid.class);
  }

  public String createTimeRecEntry(TimeRecEntry timeRecEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("conf", timeRecEntry);
    Map<String, String> response = post(API_DVR_TIMEREC_CREATE, parameter, Map.class);
    return response.get("uuid");
  }

  public TimeRecEntryGrid getTimeRecEntryList() throws IOException {
    return post(API_DVR_TIMEREC_GRID, null, TimeRecEntryGrid.class);
  }

  public InputGrid getInputGrid() throws IOException {
    return post(API_STATUS_INPUTS, null, InputGrid.class);
  }

  public SubscriptionGrid getSubscriptionGrid() throws IOException {
    return post(API_STATUS_SUBSCRIPTIONS, null, SubscriptionGrid.class);
  }

  public ConnectionGrid getConnectionGrid() throws IOException {
    return post(API_STATUS_CONNECTIONS, null, ConnectionGrid.class);
  }

  public KeyValList getIdNode(IdNodeRequestParameter idNodeRequestParameter) throws IOException {
    return post(API_IDNODE_LOAD, idNodeRequestParameter, KeyValList.class);
  }

  public void saveAutoRecEntry(AutoRecEntry autoRecEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("node", autoRecEntry);
    post(API_IDNODE_SAVE, parameter, Object.class);
  }

  public void saveTimeRecEntry(TimeRecEntry timeRecEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("node", timeRecEntry);
    post(API_IDNODE_SAVE, parameter, Object.class);
  }

  public void saveDvrEntry(DvrEntry dvrEntry) throws IOException {
    WrapParameter parameter = new WrapParameter("node", dvrEntry);
    post(API_IDNODE_SAVE, parameter, Object.class);
  }

  public void deleteIdNode(String[] uuidsOfSameEntity) throws IOException {
    WrapParameter params = new WrapParameter("uuid", uuidsOfSameEntity);
    post(API_IDNODE_DELETE, params, Object.class);
  }

}