package de.heckie.tvheadend.api.model.dvr;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TimeRecEntryGrid {

  private int total;

  private List<TimeRecEntry> entries;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<TimeRecEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<TimeRecEntry> entries) {
    this.entries = entries;
  }

  public TimeRecEntry getTimeRecEntryByUuid(String uuid) {
    return entries.stream().filter(e -> uuid.equals(e.getUuid())).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
