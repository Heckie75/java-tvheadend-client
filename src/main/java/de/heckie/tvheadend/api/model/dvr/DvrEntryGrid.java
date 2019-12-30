package de.heckie.tvheadend.api.model.dvr;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DvrEntryGrid {

  private int total;

  private List<DvrEntry> entries;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<DvrEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<DvrEntry> entries) {
    this.entries = entries;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
