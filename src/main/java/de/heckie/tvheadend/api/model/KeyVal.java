package de.heckie.tvheadend.api.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class KeyVal {

  private String key;
  private String val;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
