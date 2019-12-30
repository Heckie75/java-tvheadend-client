package de.heckie.tvheadend.api.model.dvr;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.StartLimitParameter;

public class DvrEntryGridRequestParameter extends StartLimitParameter {

  public final static String SORT_BY_START_REAL = "start_real";
  public final static String SORT_BY_DISP_TITLE = "disp_title";
  public final static String DIRECTION_ASC = "asc";
  public final static String DIRECTION_DESC = "desc";

  private String dir = DIRECTION_DESC;
  private String sort = SORT_BY_START_REAL;
  private Boolean groupBy;
  private String groupDir;

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

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(super.toMap());
    map.putAll(Map.of(
        "dir", dir != null ? dir : "",
        "sort", sort != null ? sort : "",
        "groupBy", groupBy != null ? String.valueOf(groupBy) : "",
        "groupDir", groupDir != null ? groupDir : ""));
    return map;
  }

}
