package de.heckie.tvheadend.api.model.channel;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import de.heckie.tvheadend.api.model.UuidEntity;

public class ChannelTag extends UuidEntity {

  private boolean enabled;
  private boolean internal;
  private boolean _private;
  private int index;
  private String name;
  private String icon;
  private String icon_public_url;
  private boolean titled_icon;
  private String comment;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isInternal() {
    return internal;
  }

  public void setInternal(boolean internal) {
    this.internal = internal;
  }

  public boolean isPrivate() {
    return _private;
  }

  public void setPrivate(boolean _private) {
    this._private = _private;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getIcon_public_url() {
    return icon_public_url;
  }

  public void setIcon_public_url(String icon_public_url) {
    this.icon_public_url = icon_public_url;
  }

  public boolean isTitled_icon() {
    return titled_icon;
  }

  public void setTitled_icon(boolean titled_icon) {
    this.titled_icon = titled_icon;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
