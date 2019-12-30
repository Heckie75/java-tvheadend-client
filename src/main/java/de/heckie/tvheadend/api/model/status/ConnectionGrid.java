package de.heckie.tvheadend.api.model.status;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ConnectionGrid {

  private List<Connection> entries;

  private int totalCount;

  public List<Connection> getEntries() {
    return entries;
  }

  public void setEntries(List<Connection> entries) {
    this.entries = entries;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
