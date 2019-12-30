package de.heckie.tvheadend.api.model.dvr;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AutoRecEntry extends AbstractRecEntry {

  private String tag;
  private String start_window;
  private String cat1;
  private String cat2;
  private String cat3;
  private boolean fulltext;
  private int btype;
  private int content_type;
  private int minyear;
  private int maxyear;
  private int minseason;
  private int maxseason;
  private int star_rating;
  private int maxcount;
  private long record;
  private long maxsched;
  private long start_extra;
  private long stop_extra;
  private long minduration;
  private long maxduration;

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

  public boolean isFulltext() {
    return fulltext;
  }

  public void setFulltext(boolean fulltext) {
    this.fulltext = fulltext;
  }

  public int getBtype() {
    return btype;
  }

  public void setBtype(int btype) {
    this.btype = btype;
  }

  public int getContent_type() {
    return content_type;
  }

  public void setContent_type(int content_type) {
    this.content_type = content_type;
  }

  public int getMinyear() {
    return minyear;
  }

  public void setMinyear(int minyear) {
    this.minyear = minyear;
  }

  public int getMaxyear() {
    return maxyear;
  }

  public void setMaxyear(int maxyear) {
    this.maxyear = maxyear;
  }

  public int getMinseason() {
    return minseason;
  }

  public void setMinseason(int minseason) {
    this.minseason = minseason;
  }

  public int getMaxseason() {
    return maxseason;
  }

  public void setMaxseason(int maxseason) {
    this.maxseason = maxseason;
  }

  public int getStar_rating() {
    return star_rating;
  }

  public void setStar_rating(int star_rating) {
    this.star_rating = star_rating;
  }

  public int getMaxcount() {
    return maxcount;
  }

  public void setMaxcount(int maxcount) {
    this.maxcount = maxcount;
  }

  public long getRecord() {
    return record;
  }

  public void setRecord(long record) {
    this.record = record;
  }

  public long getMaxsched() {
    return maxsched;
  }

  public void setMaxsched(long maxsched) {
    this.maxsched = maxsched;
  }

  public long getStart_extra() {
    return start_extra;
  }

  public void setStart_extra(long start_extra) {
    this.start_extra = start_extra;
  }

  public long getStop_extra() {
    return stop_extra;
  }

  public void setStop_extra(long stop_extra) {
    this.stop_extra = stop_extra;
  }

  public long getMinduration() {
    return minduration;
  }

  public void setMinduration(long minduration) {
    this.minduration = minduration;
  }

  public long getMaxduration() {
    return maxduration;
  }

  public void setMaxduration(long maxduration) {
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
