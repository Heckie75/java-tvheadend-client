package de.heckie.tvheadend.api.model.epg;

import java.util.Map;

import de.heckie.tvheadend.api.model.StartLimitParameter;

public class EventRequestParameter extends StartLimitParameter {

  public static final String SORT_BY_START = "start";
  public static final String SORT_BY_STOP = "stop";
  public static final String SORT_BY_CHANNEL_NUMBER = "channelNumber";
  public static final String SORT_BY_CATEGORY = "category";
  public static final String SORT_BY_TITLE = "title";
  public static final String SORT_BY_EXTRA_TEXT = "extratext";
  public static final String SORT_BY_EPISODE_ON_SCREEN = "episodeOnscreen";
  public static final String SORT_BY_DURATION = "duration";
  public static final String SORT_BY_CHANNEL_NAME = "channelName";
  public static final String SORT_BY_STAR_RATING = "starRating";
  public static final String SORT_BY_AGE_RATING = "ageRating";
  public static final String SORT_BY_GENRE = "genre";

  public static final String DIRECTION_DATE = "date";
  public static final String DIRECTION_ASC = "asc";
  public static final String DIRECTION_DESC = "desc";

  public static final String MODE_ALL = "all";
  public static final String MODE_NOW = "now";

  private String sort = SORT_BY_START;

  private String direction = DIRECTION_DATE;

  private String title;

  private Boolean fulltext;

  private String channel;

  private String channelTag;

  private Integer contentType;

  private Integer durationMin;

  private Integer durationMax;

  private Boolean _new;

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean isFulltext() {
    return fulltext;
  }

  public void setFulltext(Boolean fulltext) {
    this.fulltext = fulltext;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getChannelTag() {
    return channelTag;
  }

  public void setChannelTag(String channelTag) {
    this.channelTag = channelTag;
  }

  public Integer getContentType() {
    return contentType;
  }

  public void setContentType(Integer contentType) {
    this.contentType = contentType;
  }

  public Integer getDurationMin() {
    return durationMin;
  }

  public void setDurationMin(Integer durationMin) {
    this.durationMin = durationMin;
  }

  public Integer getDurationMax() {
    return durationMax;
  }

  public void setDurationMax(Integer durationMax) {
    this.durationMax = durationMax;
  }

  public Boolean isNew() {
    return _new;
  }

  public void setNew(Boolean _new) {
    this._new = _new;
  }

  @Override
  public Map<String, String> toMap() {
    Map<String, String> map = super.toMap();
    map.putAll(Map.of("sort", sort != null ? sort : "",
        "direction", direction != null ? direction : "",
        "title", title != null ? title : "",
        "fulltext", fulltext != null ? String.valueOf(fulltext) : "",
        "channel", channel != null ? channel : "",
        "channelTag", channelTag != null ? channelTag : "",
        "contentType", contentType != null ? String.valueOf(contentType) : "",
        "durationMin", durationMin != null ? String.valueOf(durationMin) : "",
        "durationMax", durationMax != null ? String.valueOf(durationMax) : "",
        "new", _new != null ? String.valueOf(_new) : ""));
    return map;
  }
}
