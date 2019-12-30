package de.heckie.tvheadend.api.model.status;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SubscriptionGrid {

  private List<Subscription> entries;

  private int totalCount;

  public List<Subscription> getEntries() {
    return entries;
  }

  public void setEntries(List<Subscription> entries) {
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
