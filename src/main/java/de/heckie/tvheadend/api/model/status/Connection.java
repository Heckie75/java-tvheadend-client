package de.heckie.tvheadend.api.model.status;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Connection {

  private int id;
  private String server;
  private String peer;
  private String type;
  private String user;
  private int server_port;
  private int peer_port;
  private long started;
  private int streaming;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public String getPeer() {
    return peer;
  }

  public void setPeer(String peer) {
    this.peer = peer;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public int getServer_port() {
    return server_port;
  }

  public void setServer_port(int server_port) {
    this.server_port = server_port;
  }

  public int getPeer_port() {
    return peer_port;
  }

  public void setPeer_port(int peer_port) {
    this.peer_port = peer_port;
  }

  public long getStarted() {
    return started;
  }

  public void setStarted(long started) {
    this.started = started;
  }

  public int getStreaming() {
    return streaming;
  }

  public void setStreaming(int streaming) {
    this.streaming = streaming;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
