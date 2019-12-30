package de.heckie.tvheadend.api.model.idnode;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.AbstractParams;

public class IdNodeRequestParameter extends AbstractParams {

  private Integer _enum = 1;

  private String clazz;

  public Integer getEnum() {
    return _enum;
  }

  public void setEnum(Integer _enum) {
    this._enum = _enum;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of(
        "enum", _enum != null ? String.valueOf(_enum) : "",
        "class", clazz != null ? clazz : ""));
    return map;
  }

}
