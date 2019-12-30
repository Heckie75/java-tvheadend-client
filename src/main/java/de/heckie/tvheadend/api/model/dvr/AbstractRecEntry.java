package de.heckie.tvheadend.api.model.dvr;

import de.heckie.tvheadend.api.model.UuidEntity;

public abstract class AbstractRecEntry extends UuidEntity {

  private boolean enabled;
  private String name;
  private String title;
  private String channel;
  private String start;
  private int[] weekdays;
  private int pri;
  private int retention;
  private int removal; // ok
  private String directory;
  private String config_name;
  private String owner;
  private String creator;
  private String comment;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getConfig_name() {
    return config_name;
  }

  public void setConfig_name(String config_name) {
    this.config_name = config_name;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public int getPri() {
    return pri;
  }

  public void setPri(int pri) {
    this.pri = pri;
  }

  public int getRetention() {
    return retention;
  }

  public void setRetention(int retention) {
    this.retention = retention;
  }

  public int getRemoval() {
    return removal;
  }

  public void setRemoval(int removal) {
    this.removal = removal;
  }

  public int[] getWeekdays() {
    return weekdays;
  }

  public void setWeekdays(int[] weekdays) {
    this.weekdays = weekdays;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }
}
