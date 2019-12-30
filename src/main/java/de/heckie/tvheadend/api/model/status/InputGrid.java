package de.heckie.tvheadend.api.model.status;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class InputGrid {

  private List<Input> entries;

  private int totalCount;

  public List<Input> getEntries() {
    return entries;
  }

  public void setEntries(List<Input> entries) {
    this.entries = entries;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public Input getByUuid(String uuid) {
    return entries.stream().filter(i -> i.getUuid().equals(uuid)).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
