package de.heckie.tvheadend.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.heckie.tvheadend.api.model.KeyValList;
import de.heckie.tvheadend.api.model.channel.BouquetGrid;
import de.heckie.tvheadend.api.model.channel.ChannelGrid;
import de.heckie.tvheadend.api.model.channel.ChannelGridRequestParameter;
import de.heckie.tvheadend.api.model.channel.ChannelListRequestParameter;
import de.heckie.tvheadend.api.model.channel.ChannelTagGrid;
import de.heckie.tvheadend.api.model.channel.ChannelTagGridRequestParameter;
import de.heckie.tvheadend.api.model.dvr.AutoRecEntryGrid;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGrid;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGridRequestParameter;
import de.heckie.tvheadend.api.model.dvr.TimeRecEntryGrid;
import de.heckie.tvheadend.api.model.epg.EventGrid;
import de.heckie.tvheadend.api.model.epg.EventRequestParameter;
import de.heckie.tvheadend.api.model.idnode.IdNodeRequestParameter;
import de.heckie.tvheadend.api.model.status.ConnectionGrid;
import de.heckie.tvheadend.api.model.status.InputGrid;
import de.heckie.tvheadend.api.model.status.SubscriptionGrid;

class ClientTest {

  private static TvheadendClient client;

  @BeforeAll
  static void init() throws Exception {
    client = new TvheadendClient("http://192.168.178.28:9981/", "tvheadendadmin", "tvheadendadmin");
  }

  @Test
  void testClient() {
    assertNotEquals(client, null);
  }

  @Test
  void testGetCapabilities() throws Exception {

    List<String> capabilities = client.getCapabilities();
    assertFalse(capabilities.isEmpty());
    assertEquals("caclient", capabilities.get(0));

  }

  @Test
  void testGetGenreTypes() throws Exception {
    KeyValList genreTypes = client.getGenreTypes();
    assertFalse(genreTypes.getEntries().isEmpty());
    assertEquals(11, genreTypes.getEntries().size());
    assertEquals("Movie / Drama", genreTypes.getValByKey("16"));
  }

  @Test
  void testGetChannelTagList() throws Exception {
    KeyValList channelTagList = client.getChannelTagList();
    assertFalse(channelTagList.getEntries().isEmpty());
    assertEquals("Türkisch", channelTagList.getValByKey("5c80e11fd43118c6f96baf24db7e487e"));
    assertEquals("c4aa4fabef542afe08787777aae417c4", channelTagList.getEntries().get(0).getKey());
  }

  @Test
  void testGetChannelTagGrid() throws Exception {
    ChannelTagGridRequestParameter channelTagGridRequestParameter = new ChannelTagGridRequestParameter();
    channelTagGridRequestParameter.setSort(ChannelTagGridRequestParameter.SORT_BY_NAME);
    channelTagGridRequestParameter.setDir(ChannelTagGridRequestParameter.DIRECTION_DESC);
    ChannelTagGrid channelTagGrid = client.getChannelTagGrid(channelTagGridRequestParameter);
    assertFalse(channelTagGrid.getEntries().isEmpty());
    assertEquals(channelTagGrid.getTotal(), channelTagGrid.getEntries().size());
    assertEquals("Türkisch", channelTagGrid.getByUUID("5c80e11fd43118c6f96baf24db7e487e").getName());
    assertTrue(channelTagGrid.getEntries().get(0).getName()
        .compareTo(channelTagGrid.getEntries().get(channelTagGrid.getEntries().size() - 1).getName()) > 0);
  }

  @Test
  void testGetChannelCategoryList() throws Exception {
    KeyValList channelCategoryList = client.getChannelCategoryList();
    assertTrue(channelCategoryList.getEntries().isEmpty());
  }

  @Test
  void testGetChannelList() throws Exception {
    ChannelListRequestParameter channelListRequestParameter = new ChannelListRequestParameter();
    channelListRequestParameter.setAll(1);
    channelListRequestParameter.setNumbers(1);
    KeyValList channelList = client.getChannelList(channelListRequestParameter);
    assertFalse(channelList.getEntries().isEmpty());
    assertTrue(channelList.getEntries().get(0).getVal().startsWith("1 "));
    assertEquals("2 ZDF HD", channelList.getValByKey("9691967511cee40ea6b4e7d58e8199ec"));
  }

  @Test
  void testGetChannelGrid() throws Exception {

    ChannelGridRequestParameter channelGridRequestParameter = new ChannelGridRequestParameter();
    channelGridRequestParameter.setLimit(42);
    channelGridRequestParameter.setDir(ChannelGridRequestParameter.DIRECTION_DESC);
    channelGridRequestParameter.setSort(ChannelGridRequestParameter.SORT_BY_NUMBER);
    ChannelGrid channelGrid = client.getChannelGrid(channelGridRequestParameter);
    assertFalse(channelGrid.getEntries().isEmpty());
    assertFalse(channelGrid.getTotal() == channelGrid.getEntries().size());
    assertEquals(42, channelGrid.getEntries().size());
  }

  @Test
  void testGetBouquetGrid() throws Exception {
    BouquetGrid bouquetGrid = client.getBouquetGrid(null);
    assertFalse(bouquetGrid.getEntries().isEmpty());
    assertEquals(bouquetGrid.getTotal(), bouquetGrid.getEntries().size());
    assertEquals("c2d90c85f3dc2aeae6c4b4a3b82e6a77", bouquetGrid.getByUUID("c2d90c85f3dc2aeae6c4b4a3b82e6a77").getUuid());
  }

  @Test
  void testGetEvents() throws Exception {
    EventRequestParameter eventRequestParameter = new EventRequestParameter();
    eventRequestParameter.setFulltext(true);
    eventRequestParameter.setLimit(Integer.MAX_VALUE);
    eventRequestParameter.setTitle("Tagesschau vor 20 Jahren");
    EventGrid events = client.getEvents(eventRequestParameter);
    assertFalse(events.getEntries().isEmpty());
    assertEquals(events.getTotalCount(), events.getEntries().size());
    assertEquals("Die Tagesschau vor 20 Jahren", events.getEntries().get(0).getTitle());
  }

  @Test
  void testGetUpcomingDvrEntryList() throws Exception {
    DvrEntryGridRequestParameter dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    client.getUpcomingDvrEntryList(dvrEntryGridRequestParameter);
  }

  @Test
  void testGetFinishedDvrEntryList() throws Exception {
    DvrEntryGridRequestParameter dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    DvrEntryGrid finishedDvrEntryList = client.getFinishedDvrEntryList(dvrEntryGridRequestParameter);
    assertFalse(finishedDvrEntryList.getEntries().isEmpty());
    assertEquals(finishedDvrEntryList.getEntries().size(), finishedDvrEntryList.getTotal());
  }

  @Test
  void testGetFailedDvrEntryList() throws Exception {
    DvrEntryGridRequestParameter dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    DvrEntryGrid failedDvrEntryList = client.getFailedDvrEntryList(dvrEntryGridRequestParameter);
    assertTrue(failedDvrEntryList.getEntries().isEmpty());
    assertEquals(failedDvrEntryList.getEntries().size(), failedDvrEntryList.getTotal());
  }

  @Test
  void testGetRemovedDvrEntryList() throws Exception {
    DvrEntryGridRequestParameter dvrEntryGridRequestParameter = new DvrEntryGridRequestParameter();
    DvrEntryGrid removedDvrEntryList = client.getRemovedDvrEntryList(dvrEntryGridRequestParameter);
    assertEquals(removedDvrEntryList.getEntries().size(), removedDvrEntryList.getTotal());
  }

  @Test
  void testGetAutoRecEntryList() throws Exception {
    AutoRecEntryGrid autoRecEntryList = client.getAutoRecEntryList();
    assertEquals(autoRecEntryList.getEntries().size(), autoRecEntryList.getTotal());
  }

  @Test
  void testGetTimeRecEntryList() throws Exception {
    TimeRecEntryGrid timeRecEntryList = client.getTimeRecEntryList();
    assertEquals(timeRecEntryList.getEntries().size(), timeRecEntryList.getTotal());
  }

  @Test
  void testGetInputGrid() throws Exception {
    InputGrid inputGrid = client.getInputGrid();
    assertFalse(inputGrid.getEntries().isEmpty());
    assertEquals(inputGrid.getTotalCount(), inputGrid.getEntries().size());
  }

  @Test
  void testGetSubscriptionGrid() throws Exception {
    SubscriptionGrid subscriptionGrid = client.getSubscriptionGrid();
    assertEquals(subscriptionGrid.getTotalCount(), subscriptionGrid.getEntries().size());
  }

  @Test
  void testGetConnectionGrid() throws Exception {
    ConnectionGrid connectionGrid = client.getConnectionGrid();
    assertEquals(connectionGrid.getTotalCount(), connectionGrid.getEntries().size());
  }

  @Test
  void testGetIdNode() throws Exception {
    IdNodeRequestParameter idNodeRequestParameter = new IdNodeRequestParameter();
    idNodeRequestParameter.setClazz(TvheadendClient.ID_NODE_CLASS_DVR_CONFIG);
    KeyValList idNode = client.getIdNode(idNodeRequestParameter);
    assertEquals(TvheadendClient.DVR_DEFAULT_PROFILE, idNode.getByVal(TvheadendClient.DVR_DEFAULT_PROFILE).getVal());
  }

  @Test
  void testCreateDvrEntryByEvent() throws Exception {
    List<String> createDvrEntryByEvent = client.createDvrEntryByEvent(2098006, null);
    assertFalse(createDvrEntryByEvent.isEmpty());
  }

  @Test
  void testCreateDvrAutoRecByEvent() throws Exception {
    List<String> createDvrEntryByEvent = client.createDvrAutoRecByEvent(2098006, null);
    assertFalse(createDvrEntryByEvent.isEmpty());
  }

}
