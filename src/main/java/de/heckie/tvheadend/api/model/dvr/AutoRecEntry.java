package de.heckie.tvheadend.api.model.dvr;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AutoRecEntry extends AbstractRecEntry {

  public final static String ANY = "Any";

  private String tag;
  private String start_window;
  private String cat1;
  private String cat2;
  private String cat3;
  private Boolean fulltext;
  private Integer btype;
  private Integer content_type;
  private Integer minyear;
  private Integer maxyear;
  private Integer minseason;
  private Integer maxseason;
  private Integer star_rating;
  private Integer maxcount;
  private Long record;
  private Integer maxsched;
  private Long start_extra;
  private Long stop_extra;
  private Long minduration;
  private Long maxduration;

  public AutoRecEntry() {

  }

  public AutoRecEntry(String name, String title, boolean fulltext, String channel, String start, String start_window,
      int[] weekdays, String comment, long record, String tag, int btype, int content_type, String config_name, int pri,
      String cat1, String cat2, String cat3, long minduration, long maxduration, int minyear, int maxyear, int minseason,
      int maxseason, int star_rating, String directory) {
    this.name = name;
    this.title = title;
    this.fulltext = Boolean.valueOf(fulltext);
    this.channel = channel;
    this.start = start;
    this.start_window = start_window;
    this.weekdays = weekdays;
    this.comment = comment;
    this.record = Long.valueOf(record);
    this.tag = tag;
    this.btype = Integer.valueOf(btype);
    this.content_type = Integer.valueOf(content_type);
    this.config_name = config_name;
    this.pri = Integer.valueOf(pri);
    this.cat1 = cat1;
    this.cat2 = cat2;
    this.cat3 = cat3;
    this.minduration = Long.valueOf(minduration);
    this.maxduration = Long.valueOf(maxduration);
    this.minyear = Integer.valueOf(minyear);
    this.maxyear = Integer.valueOf(maxyear);
    this.minseason = Integer.valueOf(minseason);
    this.maxseason = Integer.valueOf(maxseason);
    this.star_rating = Integer.valueOf(star_rating);
    this.directory = directory;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getStart_window() {
    return start_window;
  }

  public void setStart_window(String start_window) {
    this.start_window = start_window;
  }

  public Boolean isFulltext() {
    return fulltext;
  }

  public void setFulltext(Boolean fulltext) {
    this.fulltext = fulltext;
  }

  public Integer getBtype() {
    return btype;
  }

  public void setBtype(Integer btype) {
    this.btype = btype;
  }

  public Integer getContent_type() {
    return content_type;
  }

  public void setContent_type(Integer content_type) {
    this.content_type = content_type;
  }

  public Integer getMinyear() {
    return minyear;
  }

  public void setMinyear(Integer minyear) {
    this.minyear = minyear;
  }

  public Integer getMaxyear() {
    return maxyear;
  }

  public void setMaxyear(Integer maxyear) {
    this.maxyear = maxyear;
  }

  public Integer getMinseason() {
    return minseason;
  }

  public void setMinseason(Integer minseason) {
    this.minseason = minseason;
  }

  public Integer getMaxseason() {
    return maxseason;
  }

  public void setMaxseason(Integer maxseason) {
    this.maxseason = maxseason;
  }

  public Integer getStar_rating() {
    return star_rating;
  }

  public void setStar_rating(Integer star_rating) {
    this.star_rating = star_rating;
  }

  public Integer getMaxcount() {
    return maxcount;
  }

  public void setMaxcount(Integer maxcount) {
    this.maxcount = maxcount;
  }

  public Long getRecord() {
    return record;
  }

  public void setRecord(Long record) {
    this.record = record;
  }

  public Integer getMaxsched() {
    return maxsched;
  }

  public void setMaxsched(Integer maxsched) {
    this.maxsched = maxsched;
  }

  public Long getStart_extra() {
    return start_extra;
  }

  public void setStart_extra(Long start_extra) {
    this.start_extra = start_extra;
  }

  public Long getStop_extra() {
    return stop_extra;
  }

  public void setStop_extra(Long stop_extra) {
    this.stop_extra = stop_extra;
  }

  public Long getMinduration() {
    return minduration;
  }

  public void setMinduration(Long minduration) {
    this.minduration = minduration;
  }

  public Long getMaxduration() {
    return maxduration;
  }

  public void setMaxduration(Long maxduration) {
    this.maxduration = maxduration;
  }

  public String getCat1() {
    return cat1;
  }

  public void setCat1(String cat1) {
    this.cat1 = cat1;
  }

  public String getCat2() {
    return cat2;
  }

  public void setCat2(String cat2) {
    this.cat2 = cat2;
  }

  public String getCat3() {
    return cat3;
  }

  public void setCat3(String cat3) {
    this.cat3 = cat3;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
