package de.heckie.tvheadend.api.model.epg;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Event {

  public final static long TIME_OFFSET = new Date(70, 0, 1, 0, 0, 0).getTime();

  private long eventId;
  private String channelUuid;
  private String channelNumber;
  private String channelName;
  private String title;
  private String subtitle;
  private String description;
  private String channelIcon;
  private long start;
  private long stop;
  private int bw;
  private int hd;
  private int subtitled;
  private int widescreen;
  private String audiodesc;
  private long nextEventId;
  private int ageRating;
  private String dvrUuid;
  private String dvrState;

  private int[] genre;

  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public String getChannelUuid() {
    return channelUuid;
  }

  public void setChannelUuid(String channelUuid) {
    this.channelUuid = channelUuid;
  }

  public String getChannelNumber() {
    return channelNumber;
  }

  public void setChannelNumber(String channelNumber) {
    this.channelNumber = channelNumber;
  }

  public long getStart() {
    return start;
  }

  public Date getStartDate() {
    return new Date(start * 1000L);
  }

  public void setStart(long start) {
    this.start = start;
  }

  public long getStop() {
    return stop;
  }

  public Date getStopDate() {
    return new Date(stop * 1000L);
  }

  public void setStop(long stop) {
    this.stop = stop;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getNextEventId() {
    return nextEventId;
  }

  public void setNextEventId(long nextEventId) {
    this.nextEventId = nextEventId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public int getSubtitled() {
    return subtitled;
  }

  public void setSubtitled(int subtitled) {
    this.subtitled = subtitled;
  }

  public int getHd() {
    return hd;
  }

  public void setHd(int hd) {
    this.hd = hd;
  }

  public int getBw() {
    return bw;
  }

  public void setBw(int bw) {
    this.bw = bw;
  }

  public int getWidescreen() {
    return widescreen;
  }

  public void setWidescreen(int widescreen) {
    this.widescreen = widescreen;
  }

  public int[] getGenre() {
    return genre;
  }

  public void setGenre(int[] genre) {
    this.genre = genre;
  }

  public int getAgeRating() {
    return ageRating;
  }

  public void setAgeRating(int ageRating) {
    this.ageRating = ageRating;
  }

  public String getDvrUuid() {
    return dvrUuid;
  }

  public void setDvrUuid(String dvrUuid) {
    this.dvrUuid = dvrUuid;
  }

  public String getDvrState() {
    return dvrState;
  }

  public void setDvrState(String dvrState) {
    this.dvrState = dvrState;
  }

  public String getChannelIcon() {
    return channelIcon;
  }

  public void setChannelIcon(String channelIcon) {
    this.channelIcon = channelIcon;
  }

  public String getAudiodesc() {
    return audiodesc;
  }

  public void setAudiodesc(String audiodesc) {
    this.audiodesc = audiodesc;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
