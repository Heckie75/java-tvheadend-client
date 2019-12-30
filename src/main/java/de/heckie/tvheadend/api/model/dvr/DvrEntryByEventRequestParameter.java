package de.heckie.tvheadend.api.model.dvr;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.AbstractParams;

public class DvrEntryByEventRequestParameter extends AbstractParams {

  private Long eventId;

  private String configUuid;

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public String getConfigUuid() {
    return configUuid;
  }

  public void setConfigUuid(String configUuid) {
    this.configUuid = configUuid;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of(
        "config_uuid", configUuid != null ? configUuid : "",
        "event_id", eventId != null ? String.valueOf(eventId) : ""));
    return map;
  }

}
