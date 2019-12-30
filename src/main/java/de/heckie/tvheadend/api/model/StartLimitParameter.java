package de.heckie.tvheadend.api.model;

import java.util.HashMap;
import java.util.Map;

public class StartLimitParameter extends AbstractParams {

  private Integer start = 0;
  private Integer limit = Integer.MAX_VALUE;

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of("start", start != null ? String.valueOf(start) : "",
        "limit", limit != null ? String.valueOf(limit) : ""));
    return map;
  }
}
