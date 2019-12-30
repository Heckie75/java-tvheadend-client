package de.heckie.tvheadend.api.model.channel;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import de.heckie.tvheadend.api.model.UuidEntity;

public class Channel extends UuidEntity {

  public String name;
  public String icon;
  public String icon_public_url;
  public String epg_parent;

  public String[] services;
  public String[] tags;
  public String bouquet;

  public boolean enabled;
  public boolean autoname;
  public boolean epgauto;

  public int epglimit;
  public int number;

  public int dvr_pre_time;
  public int dvr_pst_time;
  public int epg_running;

  public String[] epggrab;

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

  public String getEpg_parent() {
    return epg_parent;
  }

  public void setEpg_parent(String epg_parent) {
    this.epg_parent = epg_parent;
  }

  public String[] getServices() {
    return services;
  }

  public void setServices(String[] services) {
    this.services = services;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  public String getBouquet() {
    return bouquet;
  }

  public void setBouquet(String bouquet) {
    this.bouquet = bouquet;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isAutoname() {
    return autoname;
  }

  public void setAutoname(boolean autoname) {
    this.autoname = autoname;
  }

  public boolean isEpgauto() {
    return epgauto;
  }

  public void setEpgauto(boolean epgauto) {
    this.epgauto = epgauto;
  }

  public int getEpglimit() {
    return epglimit;
  }

  public void setEpglimit(int epglimit) {
    this.epglimit = epglimit;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getDvr_pre_time() {
    return dvr_pre_time;
  }

  public void setDvr_pre_time(int dvr_pre_time) {
    this.dvr_pre_time = dvr_pre_time;
  }

  public int getDvr_pst_time() {
    return dvr_pst_time;
  }

  public void setDvr_pst_time(int dvr_pst_time) {
    this.dvr_pst_time = dvr_pst_time;
  }

  public int getEpg_running() {
    return epg_running;
  }

  public void setEpg_running(int epg_running) {
    this.epg_running = epg_running;
  }

  public String[] getEpggrab() {
    return epggrab;
  }

  public void setEpggrab(String[] epggrab) {
    this.epggrab = epggrab;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}