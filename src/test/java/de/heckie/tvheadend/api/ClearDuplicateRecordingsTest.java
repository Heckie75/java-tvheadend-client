package de.heckie.tvheadend.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.heckie.tvheadend.api.model.dvr.DvrEntry;
import de.heckie.tvheadend.api.model.dvr.DvrEntryGrid;

class ClearDuplicateRecordingsTest {

  private static TvheadendHttpClient client;

  @BeforeAll
  static void init() throws Exception {
    client = new TvheadendHttpClient("http://192.168.178.30:9981/", "tvheadendadmin", "tvheadendadmin");
  }

  @Test
  void testGetFinishedDvrEntryList() throws Exception {

    DvrEntryGrid finishedDvrEntryList = client.getFinishedDvrEntryList(false);
    Map<String, List<DvrEntry>> recordings = new HashMap<>();

    for (DvrEntry entry : finishedDvrEntryList.getEntries()) {

      String subtitle = entry.getDisp_subtitle();
      if (!recordings.containsKey(subtitle)) {
        recordings.put(subtitle, new ArrayList<DvrEntry>());
      }

      recordings.get(subtitle).add(entry);
    }

    for (Map.Entry<String, List<DvrEntry>> entry : recordings.entrySet()) {

      if (entry.getValue().size() > 1 && StringUtils.isNotEmpty(entry.getKey())) {
        System.out.println(entry.getKey() + "\t" + entry.getValue().size());
      }
    }
  }
}
