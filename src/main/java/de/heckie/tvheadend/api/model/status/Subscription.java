package de.heckie.tvheadend.api.model.status;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Subscription {

  private int id;
  private long start;
  private int errors;
  private String state;
  private String hostname;
  private String username;
  private String client;
  private String title;
  private String channel;
  private String service;
  private int[] pids;
  private String profile;
  private long in;
  private long out;
  private long total_in;
  private long total_out;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public int getErrors() {
    return errors;
  }

  public void setErrors(int errors) {
    this.errors = errors;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
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

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public int[] getPids() {
    return pids;
  }

  public void setPids(int[] pids) {
    this.pids = pids;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public long getIn() {
    return in;
  }

  public void setIn(long in) {
    this.in = in;
  }

  public long getOut() {
    return out;
  }

  public void setOut(long out) {
    this.out = out;
  }

  public long getTotal_in() {
    return total_in;
  }

  public void setTotal_in(long total_in) {
    this.total_in = total_in;
  }

  public long getTotal_out() {
    return total_out;
  }

  public void setTotal_out(long total_out) {
    this.total_out = total_out;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}