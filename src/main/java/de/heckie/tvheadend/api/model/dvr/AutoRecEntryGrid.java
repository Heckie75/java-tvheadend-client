package de.heckie.tvheadend.api.model.dvr;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AutoRecEntryGrid {

  private int total;

  private List<AutoRecEntry> entries;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<AutoRecEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<AutoRecEntry> entries) {
    this.entries = entries;
  }

  public AutoRecEntry getAutoRecEntryByUuid(String uuid) {
    return entries.stream().filter(a -> uuid.equals(a.getUuid())).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
