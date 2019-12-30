package de.heckie.tvheadend.api.model.channel;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ChannelTagGrid {

  private List<ChannelTag> entries;

  private int total;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<ChannelTag> getEntries() {
    return entries;
  }

  public void setEntries(List<ChannelTag> entries) {
    this.entries = entries;
  }

  public ChannelTag getByUUID(String uuid) {
    return entries.stream().filter(c -> c.getUuid().equals(uuid)).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}