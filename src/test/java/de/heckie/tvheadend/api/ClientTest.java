package de.heckie.tvheadend.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.heckie.tvheadend.api.model.KeyVal;
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

class ClientTest {

  private static TvheadendHttpClient client;

  private static List<String> dvrEntriesToDelete = new ArrayList<>();
  private static List<String> autorecsToDelete = new ArrayList<>();
  private static List<String> timerecsToDelete = new ArrayList<>();

  @BeforeAll
  static void init() throws Exception {
    client = new TvheadendHttpClient("http://192.168.178.30:9981/", "tvheadendadmin", "tvheadendadmin");
    // client = new TvheadendHttpClient("http://heckie72.my-wan.de:9981/", "kodi", "kodi2022");
  }

  @Test
  void testClient() {
    assertNotEquals(client, null);
  }

  @Test
  void testGetCapabilities() throws Exception {
    List<String> capabilities = client.getCapabilities(false);
    assertFalse(capabilities.isEmpty());
    assertEquals("caclient", capabilities.get(0));

    capabilities = client.getCapabilities(false);
    assertFalse(capabilities.isEmpty());
    assertEquals("caclient", capabilities.get(0));
  }

  @Test
  void testGetGenreTypes() throws Exception {
    KeyValList genreTypes = client.getGenreTypes(false);
    assertFalse(genreTypes.getEntries().isEmpty());
    assertEquals(11, genreTypes.getEntries().size());
    assertEquals("Movie / Drama", genreTypes.getValByKey("16"));

    genreTypes = client.getGenreTypes(false);
    assertFalse(genreTypes.getEntries().isEmpty());
    assertEquals(11, genreTypes.getEntries().size());
    assertEquals("Movie / Drama", genreTypes.getValByKey("16"));
  }

  @Test
  void testGetChannelTagList() throws Exception {
    KeyValList channelTagList = client.getChannelTagList(false);
    assertFalse(channelTagList.getEntries().isEmpty());
    assertEquals("Türkisch", channelTagList.getValByKey("5c80e11fd43118c6f96baf24db7e487e"));
    assertEquals("c4aa4fabef542afe08787777aae417c4", channelTagList.getEntries().get(0).getKey());

    channelTagList = client.getChannelTagList(false);
    assertFalse(channelTagList.getEntries().isEmpty());
    assertEquals("Türkisch", channelTagList.getValByKey("5c80e11fd43118c6f96baf24db7e487e"));
    assertEquals("c4aa4fabef542afe08787777aae417c4", channelTagList.getEntries().get(0).getKey());
  }

  @Test
  void testGetChannelTagGrid() throws Exception {
    ChannelTagGrid channelTagGrid = client.getChannelTagGrid(false);
    assertFalse(channelTagGrid.getEntries().isEmpty());
    assertEquals(channelTagGrid.getTotal(), channelTagGrid.getEntries().size());
    assertEquals("Türkisch", channelTagGrid.getByUUID("5c80e11fd43118c6f96baf24db7e487e").getName());
    assertTrue(channelTagGrid.getEntries().get(0).getName()
        .compareTo(channelTagGrid.getEntries().get(channelTagGrid.getEntries().size() - 1).getName()) < 0);

    channelTagGrid = client.getChannelTagGrid(false);
    assertFalse(channelTagGrid.getEntries().isEmpty());
    assertEquals(channelTagGrid.getTotal(), channelTagGrid.getEntries().size());
    assertEquals("Türkisch", channelTagGrid.getByUUID("5c80e11fd43118c6f96baf24db7e487e").getName());
    assertTrue(channelTagGrid.getEntries().get(0).getName()
        .compareTo(channelTagGrid.getEntries().get(channelTagGrid.getEntries().size() - 1).getName()) < 0);

  }

  @Test
  void testGetChannelCategoryList() throws Exception {
    KeyValList channelCategoryList = client.getChannelCategoryList(false);
    assertTrue(channelCategoryList.getEntries().isEmpty());

    channelCategoryList = client.getChannelCategoryList(false);
    assertTrue(channelCategoryList.getEntries().isEmpty());
  }

  @Test
  void testGetChannelList() throws Exception {
    KeyValList channelList = client.getChannelList(false, false);
    assertFalse(channelList.getEntries().isEmpty());
    assertTrue(channelList.getEntries().get(0).getVal().equals("Das Erste HD"));
    assertEquals("ZDF HD", channelList.getValByKey("9691967511cee40ea6b4e7d58e8199ec"));

    channelList = client.getChannelList(false, false);
    assertFalse(channelList.getEntries().isEmpty());
    assertTrue(channelList.getEntries().get(0).getVal().equals("Das Erste HD"));
    assertEquals("ZDF HD", channelList.getValByKey("9691967511cee40ea6b4e7d58e8199ec"));
  }

  @Test
  void testGetChannelGrid() throws Exception {
    ChannelGrid channelGrid = client.getChannelGrid(false);
    assertFalse(channelGrid.getEntries().isEmpty());
    assertTrue(channelGrid.getTotal() == channelGrid.getEntries().size());

    channelGrid = client.getChannelGrid(false);
    assertFalse(channelGrid.getEntries().isEmpty());
    assertTrue(channelGrid.getTotal() == channelGrid.getEntries().size());
  }

  @Test
  void testGetBouquetGrid() throws Exception {
    BouquetGrid bouquetGrid = client.getBouquetGrid(false);
    assertFalse(bouquetGrid.getEntries().isEmpty());
    assertEquals(bouquetGrid.getTotal(), bouquetGrid.getEntries().size());
    assertEquals("c2d90c85f3dc2aeae6c4b4a3b82e6a77", bouquetGrid.getByUUID("c2d90c85f3dc2aeae6c4b4a3b82e6a77").getUuid());

    bouquetGrid = client.getBouquetGrid(false);
    assertFalse(bouquetGrid.getEntries().isEmpty());
    assertEquals(bouquetGrid.getTotal(), bouquetGrid.getEntries().size());
    assertEquals("c2d90c85f3dc2aeae6c4b4a3b82e6a77", bouquetGrid.getByUUID("c2d90c85f3dc2aeae6c4b4a3b82e6a77").getUuid());
  }

  @Test
  void testGetEvents() throws Exception {
    EventGrid events = client.getEvents(false);
    assertFalse(events.getEntries().isEmpty());
    assertEquals(events.getTotalCount(), events.getEntries().size());
    Event tagesschau = events.getEntries().stream().filter(e -> e.getTitle().equals("Die Tagesschau vor 20 Jahren")).findFirst()
        .orElse(null);
    assertNotEquals(null, tagesschau);

    events = client.getEvents(false);
    assertFalse(events.getEntries().isEmpty());
    assertEquals(events.getTotalCount(), events.getEntries().size());
    tagesschau = events.getEntries().stream().filter(e -> e.getTitle().equals("Die Tagesschau vor 20 Jahren")).findFirst()
        .orElse(null);
    assertNotEquals(null, tagesschau);
  }

  @Test
  void testGetUpcomingDvrEntryList() throws Exception {
    DvrEntryGrid upcomingDvrEntryList = client.getUpcomingDvrEntryList(false);
    assertFalse(upcomingDvrEntryList.getEntries().isEmpty());
    assertEquals(upcomingDvrEntryList.getEntries().size(), upcomingDvrEntryList.getTotal());

    upcomingDvrEntryList = client.getUpcomingDvrEntryList(false);
    assertFalse(upcomingDvrEntryList.getEntries().isEmpty());
    assertEquals(upcomingDvrEntryList.getEntries().size(), upcomingDvrEntryList.getTotal());
  }

  @Test
  void testGetFinishedDvrEntryList() throws Exception {
    DvrEntryGrid finishedDvrEntryList = client.getFinishedDvrEntryList(false);
    assertFalse(finishedDvrEntryList.getEntries().isEmpty());
    assertEquals(finishedDvrEntryList.getTotal(), finishedDvrEntryList.getEntries().size());

    finishedDvrEntryList = client.getFinishedDvrEntryList(false);
    assertFalse(finishedDvrEntryList.getEntries().isEmpty());
    assertEquals(finishedDvrEntryList.getTotal(), finishedDvrEntryList.getEntries().size());
  }

  @Test
  void testGetFailedDvrEntryList() throws Exception {
    DvrEntryGrid failedDvrEntryList = client.getFailedDvrEntryList(false);
    assertTrue(failedDvrEntryList.getEntries().isEmpty());
    assertEquals(failedDvrEntryList.getEntries().size(), failedDvrEntryList.getTotal());

    failedDvrEntryList = client.getFailedDvrEntryList(false);
    assertTrue(failedDvrEntryList.getEntries().isEmpty());
    assertEquals(failedDvrEntryList.getEntries().size(), failedDvrEntryList.getTotal());
  }

  @Test
  void testGetRemovedDvrEntryList() throws Exception {
    DvrEntryGrid removedDvrEntryList = client.getRemovedDvrEntryList(false);
    assertEquals(removedDvrEntryList.getEntries().size(), removedDvrEntryList.getTotal());

    removedDvrEntryList = client.getRemovedDvrEntryList(false);
    assertEquals(removedDvrEntryList.getEntries().size(), removedDvrEntryList.getTotal());

  }

  @Test
  void testGetAutoRecEntryList() throws Exception {
    AutoRecEntryGrid autoRecEntryList = client.getAutoRecEntryList(false);
    assertEquals(autoRecEntryList.getEntries().size(), autoRecEntryList.getTotal());

    autoRecEntryList = client.getAutoRecEntryList(false);
    assertEquals(autoRecEntryList.getEntries().size(), autoRecEntryList.getTotal());

  }

  @Test
  void testGetTimeRecEntryList() throws Exception {
    TimeRecEntryGrid timeRecEntryList = client.getTimeRecEntryList(false);
    assertEquals(timeRecEntryList.getEntries().size(), timeRecEntryList.getTotal());

    timeRecEntryList = client.getTimeRecEntryList(false);
    assertEquals(timeRecEntryList.getEntries().size(), timeRecEntryList.getTotal());
  }

  @Test
  void testGetInputGrid() throws Exception {
    InputGrid inputGrid = client.getInputGrid(false);
    assertFalse(inputGrid.getEntries().isEmpty());
    assertEquals(inputGrid.getTotalCount(), inputGrid.getEntries().size());

    inputGrid = client.getInputGrid(false);
    assertFalse(inputGrid.getEntries().isEmpty());
    assertEquals(inputGrid.getTotalCount(), inputGrid.getEntries().size());
  }

  @Test
  void testGetSubscriptionGrid() throws Exception {
    SubscriptionGrid subscriptionGrid = client.getSubscriptionGrid(false);
    assertEquals(subscriptionGrid.getTotalCount(), subscriptionGrid.getEntries().size());

    subscriptionGrid = client.getSubscriptionGrid(false);
    assertEquals(subscriptionGrid.getTotalCount(), subscriptionGrid.getEntries().size());
  }

  @Test
  void testGetConnectionGrid() throws Exception {
    ConnectionGrid connectionGrid = client.getConnectionGrid(false);
    assertEquals(connectionGrid.getTotalCount(), connectionGrid.getEntries().size());

    connectionGrid = client.getConnectionGrid(false);
    assertEquals(connectionGrid.getTotalCount(), connectionGrid.getEntries().size());
  }

  @Test
  void testGetDvrDefaultConfig() throws Exception {
    String dvrDefaultConfig = client.getDvrDefaultConfig(false);
    assertEquals("bfa7ff074783192d19e552dc3983d239", dvrDefaultConfig);

    dvrDefaultConfig = client.getDvrDefaultConfig(false);
    assertEquals("bfa7ff074783192d19e552dc3983d239", dvrDefaultConfig);
  }

  @Test
  void testCreateDvrEntryByEvent() throws Exception {
    List<Event> entries = client.getEvents(false).getEntries();
    Event event = entries.get(entries.size() - 23);
    List<String> createDvrEntryByEvent = client.createDvrEntryByEvent(event.getEventId(), null);
    assertFalse(createDvrEntryByEvent.isEmpty());
    dvrEntriesToDelete.addAll(createDvrEntryByEvent);
  }

  @Test
  void testCreateDvrAutoRecByEvent() throws Exception {
    List<Event> entries = client.getEvents(false).getEntries();
    Event event = entries.get(entries.size() - 42);
    List<String> createDvrEntryByEvent = client.createDvrAutoRecByEvent(event.getEventId(), null);
    assertFalse(createDvrEntryByEvent.isEmpty());
    autorecsToDelete.addAll(createDvrEntryByEvent);
  }

  @Test
  void testCreateDvrEnty() throws Exception {
    long currentTimeMillis = System.currentTimeMillis();
    DvrEntry dvrEntry = new DvrEntry(true, "Test", "MyExtra", "cc1284ab41974a866042e73210a39ff5", currentTimeMillis / 1000 + 3600,
        currentTimeMillis / 1000 + 3600 * 2, "MyComment", "", 1, 2, 6, "bfa7ff074783192d19e552dc3983d239", "Test", "Test", 0, 0,
        null);
    String createDvrEntry = client.createDvrEntry(dvrEntry);
    assertFalse(createDvrEntry.isBlank());
    dvrEntriesToDelete.add(createDvrEntry);
  }

  @Test
  void testCreateTimeRecEnty() throws Exception {
    TimeRecEntry timeRecEntry = new TimeRecEntry(true, "TestTimeRec", "cc1284ab41974a866042e73210a39ff5", "20:00", "20:15",
        new int[] { 1, 3 }, "MyComment", "MyTitle", "bfa7ff074783192d19e552dc3983d239", "Test", "Test", 6, 0, "", 0, null);
    String createTimeRecEntry = client.createTimeRecEntry(timeRecEntry);
    assertFalse(createTimeRecEntry.isBlank());
    timerecsToDelete.add(createTimeRecEntry);
  }

  @Test
  void testCreateAutoRecEnty() throws Exception {
    AutoRecEntry autoRecEntry = new AutoRecEntry(true, "AutoRecTest", "ReqExp", true, "cc1284ab41974a866042e73210a39ff5",
        AutoRecEntry.ANY, AutoRecEntry.ANY, new int[] { 1, 2 }, "MyComment", 0, 0, 0, null, 0, 0,
        "bfa7ff074783192d19e552dc3983d239", "Test", "Test", 6, 6, null, null, null, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, null);
    String createAutoRecEntry = client.createAutoRecEntry(autoRecEntry);
    assertFalse(createAutoRecEntry.isBlank());
    autorecsToDelete.add(createAutoRecEntry);
  }

  @Test
  void testSaveTimeRecEntry() throws Exception {
    String uuid = timerecsToDelete.get(0);
    TimeRecEntryGrid timeRecEntryList = client.getTimeRecEntryList(true);
    TimeRecEntry entry = timeRecEntryList.getEntries().stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    entry.setComment("testSaveTimeRecEntry");
    client.saveTimeRecEntry(entry);

    timeRecEntryList = client.getTimeRecEntryList(true);
    entry = timeRecEntryList.getEntries().stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    assertEquals("testSaveTimeRecEntry", entry.getComment());
  }

  @Test
  void testSaveAutoRecEntry() throws Exception {
    String uuid = autorecsToDelete.get(0);
    AutoRecEntryGrid autoRecEntryList = client.getAutoRecEntryList(true);
    AutoRecEntry entry = autoRecEntryList.getEntries().stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    entry.setComment("testSaveAutoRecEntry");
    client.saveAutoRecEntry(entry);

    autoRecEntryList = client.getAutoRecEntryList(true);
    entry = autoRecEntryList.getEntries().stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    assertEquals("testSaveAutoRecEntry", entry.getComment());
  }

  @Test
  void testSaveDvrEntry() throws Exception {
    String uuid = dvrEntriesToDelete.get(0);
    Collection<DvrEntry> allDvrEntries = client.getAllDvrEntries(true);
    DvrEntry entry = allDvrEntries.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    entry.setComment("testSaveDvrEntry");
    client.saveDvrEntry(entry);

    allDvrEntries = client.getAllDvrEntries(true);
    entry = allDvrEntries.stream().filter(e -> e.getUuid().equals(uuid)).findFirst().orElse(null);
    assertEquals("testSaveDvrEntry", entry.getComment());
  }

  @Test
  void testGetEventsWithFilter() throws Exception {
    KeyVal channel = client.getChannelList(false, false).getByVal("Das Erste HD");

    Calendar cal = Calendar.getInstance();
    int y = cal.get(Calendar.YEAR);
    int m = cal.get(Calendar.MONTH);
    int d = cal.get(Calendar.DAY_OF_MONTH);
    long from = new Date(y - 1900, m, d).getTime();

    List<String> channels = List.of(channel.getKey());
    List<Event> events = client.getEvents(false, channels, from, from + 86400000L);
    events.stream().forEach(
        e -> System.out.println(e.getChannelName()
            + "\t" + new Date(e.getStart() * 1000)
            + "\t" + new Date(e.getStop() * 1000)
            + "\t" + e.getTitle()));
  }

  @AfterAll
  static void cleanup() throws Exception {

    client.deleteIdNode(dvrEntriesToDelete.toArray(new String[dvrEntriesToDelete.size()]));
    client.deleteIdNode(autorecsToDelete.toArray(new String[autorecsToDelete.size()]));
    client.deleteIdNode(timerecsToDelete.toArray(new String[timerecsToDelete.size()]));

  }

}
