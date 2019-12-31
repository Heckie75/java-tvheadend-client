package de.heckie.tvheadend.api.model.epg;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class EventGrid {

  private List<Event> entries;

  private int totalCount;

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public List<Event> getEntries() {
    return entries;
  }

  public void setEntries(List<Event> entries) {
    this.entries = entries;
  }

  public Event getEventById(long eventId) {
    return entries.stream().filter(e -> e.getEventId() == eventId).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
