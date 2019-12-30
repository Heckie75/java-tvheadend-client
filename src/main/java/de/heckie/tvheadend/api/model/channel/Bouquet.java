package de.heckie.tvheadend.api.model.channel;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import de.heckie.tvheadend.api.model.UuidEntity;

public class Bouquet extends UuidEntity {

  private String name;
  private String source;
  private String comment;
  private boolean enabled;
  private boolean maptoch;
  private boolean ssl_peer_verify;
  private Object services;
  private int services_seen;
  private int services_count;
  private String[] mapopt;
  private String[] chtag;
  private String chtag_ref;
  private int ext_url_period;
  private int lcn_off;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isMaptoch() {
    return maptoch;
  }

  public void setMaptoch(boolean maptoch) {
    this.maptoch = maptoch;
  }

  public boolean isSsl_peer_verify() {
    return ssl_peer_verify;
  }

  public void setSsl_peer_verify(boolean ssl_peer_verify) {
    this.ssl_peer_verify = ssl_peer_verify;
  }

  public Object getServices() {
    return services;
  }

  public void setServices(Object services) {
    this.services = services;
  }

  public int getServices_seen() {
    return services_seen;
  }

  public void setServices_seen(int services_seen) {
    this.services_seen = services_seen;
  }

  public int getServices_count() {
    return services_count;
  }

  public void setServices_count(int services_count) {
    this.services_count = services_count;
  }

  public String[] getMapopt() {
    return mapopt;
  }

  public void setMapopt(String[] mapopt) {
    this.mapopt = mapopt;
  }

  public String[] getChtag() {
    return chtag;
  }

  public void setChtag(String[] chtag) {
    this.chtag = chtag;
  }

  public String getChtag_ref() {
    return chtag_ref;
  }

  public void setChtag_ref(String chtag_ref) {
    this.chtag_ref = chtag_ref;
  }

  public int getExt_url_period() {
    return ext_url_period;
  }

  public void setExt_url_period(int ext_url_period) {
    this.ext_url_period = ext_url_period;
  }

  public int getLcn_off() {
    return lcn_off;
  }

  public void setLcn_off(int lcn_off) {
    this.lcn_off = lcn_off;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
