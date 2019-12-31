package de.heckie.tvheadend.api.model.dvr;

import java.util.Collection;
import java.util.Collections;
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

  public Collection<DvrEntry> getEntries() {
    return Collections.unmodifiableCollection(entries);
  }

  public void setEntries(List<DvrEntry> entries) {
    this.entries = entries;
  }

  public DvrEntry getDvrEntryByUuid(String uuid) {
    return entries.stream().filter(e -> uuid.equals(e.getUuid())).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
