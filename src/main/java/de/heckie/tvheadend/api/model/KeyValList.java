package de.heckie.tvheadend.api.model;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class KeyValList {

  private List<KeyVal> entries;

  public List<KeyVal> getEntries() {
    return entries;
  }

  public void setEntries(List<KeyVal> entries) {
    this.entries = entries;
  }

  public String getValByKey(String key) {
    return Optional.ofNullable(entries.stream().filter(kv -> key.equals(kv.getKey())).findFirst().orElse(null))
        .map(kv -> kv.getVal())
        .orElse("");
  }

  public KeyVal getByKey(String key) {
    return entries.stream().filter(kv -> key.equals(kv.getKey())).findFirst().orElse(null);
  }

  public KeyVal getByVal(String val) {
    return entries.stream().filter(kv -> val.equals(kv.getVal())).findFirst().orElse(null);
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
