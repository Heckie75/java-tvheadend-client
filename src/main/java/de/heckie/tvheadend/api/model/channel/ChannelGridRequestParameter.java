package de.heckie.tvheadend.api.model.channel;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.AbstractParams;

public class ChannelGridRequestParameter extends AbstractParams {

  public final static String SORT_BY_NUMBER = "number";
  public final static String SORT_BY_NAME = "name";
  public final static String DIRECTION_ASC = "asc";
  public final static String DIRECTION_DESC = "desc";

  private Integer start = 0;
  private Integer limit = Integer.MAX_VALUE;
  private String dir = DIRECTION_ASC;
  private String sort = SORT_BY_NUMBER;
  private Boolean groupBy;
  private String groupDir;
  private Integer all = 1;

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

  public Boolean getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(Boolean groupBy) {
    this.groupBy = groupBy;
  }

  public String getGroupDir() {
    return groupDir;
  }

  public void setGroupDir(String groupDir) {
    this.groupDir = groupDir;
  }

  public Integer getAll() {
    return all;
  }

  public void setAll(Integer all) {
    this.all = all;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of("all", all != null ? String.valueOf(all) : "",
        "start", start != null ? String.valueOf(start) : "",
        "limit", limit != null ? String.valueOf(limit) : "",
        "dir", dir != null ? dir : "",
        "sort", sort != null ? sort : "",
        "groupBy", groupBy != null ? String.valueOf(groupBy) : "",
        "groupDir", groupDir != null ? groupDir : ""));
    return map;
  }
}