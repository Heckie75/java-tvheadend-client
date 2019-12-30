package de.heckie.tvheadend.api.model.channel;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.AbstractParams;

public class BouquetGridRequestParameter extends AbstractParams {

  public final static String SORT_BY_NAME = "name";
  public final static String DIRECTION_ASC = "asc";
  public final static String DIRECTION_DESC = "desc";

  private String dir = DIRECTION_ASC;
  private String sort = SORT_BY_NAME;

  public String getDir() {
    return dir;
  }

  public void setDir(String dir) {
    this.dir = dir;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of(
        "dir", dir != null ? dir : "",
        "sort", sort != null ? sort : ""));
    return map;
  }
}