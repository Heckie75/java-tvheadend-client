package de.heckie.tvheadend.api.model.channel;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ChannelGrid {

  private List<Channel> entries;

  private int total;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<Channel> getEntries() {
    return entries;
  }

  public void setEntries(List<Channel> entries) {
    this.entries = entries;
  }

  public Channel getByUUID(String uuid) {
    return entries.stream().filter(c -> c.getUuid() == uuid).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}