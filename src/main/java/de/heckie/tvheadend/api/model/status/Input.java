package de.heckie.tvheadend.api.model.status;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import de.heckie.tvheadend.api.model.UuidEntity;

public class Input extends UuidEntity {

  private String input;
  private String stream;
  private int[] pids;
  private int subs;
  private int weight;
  private int signal;
  private int signal_scale;
  private int ber;
  private int snr;
  private int snr_scale;
  private int unc;
  private int bps;
  private int te;
  private int cc;
  private int ec_bit;
  private int tc_bit;
  private int ec_block;
  private int tc_block;

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public int getSubs() {
    return subs;
  }

  public void setSubs(int subs) {
    this.subs = subs;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getSignal() {
    return signal;
  }

  public void setSignal(int signal) {
    this.signal = signal;
  }

  public int getSignal_scale() {
    return signal_scale;
  }

  public void setSignal_scale(int signal_scale) {
    this.signal_scale = signal_scale;
  }

  public int getBer() {
    return ber;
  }

  public void setBer(int ber) {
    this.ber = ber;
  }

  public int getSnr() {
    return snr;
  }

  public void setSnr(int snr) {
    this.snr = snr;
  }

  public int getSnr_scale() {
    return snr_scale;
  }

  public void setSnr_scale(int snr_scale) {
    this.snr_scale = snr_scale;
  }

  public int getUnc() {
    return unc;
  }

  public void setUnc(int unc) {
    this.unc = unc;
  }

  public int getBps() {
    return bps;
  }

  public void setBps(int bps) {
    this.bps = bps;
  }

  public int getTe() {
    return te;
  }

  public void setTe(int te) {
    this.te = te;
  }

  public int getCc() {
    return cc;
  }

  public void setCc(int cc) {
    this.cc = cc;
  }

  public int getEc_bit() {
    return ec_bit;
  }

  public void setEc_bit(int ec_bit) {
    this.ec_bit = ec_bit;
  }

  public int getTc_bit() {
    return tc_bit;
  }

  public void setTc_bit(int tc_bit) {
    this.tc_bit = tc_bit;
  }

  public int getEc_block() {
    return ec_block;
  }

  public void setEc_block(int ec_block) {
    this.ec_block = ec_block;
  }

  public int getTc_block() {
    return tc_block;
  }

  public void setTc_block(int tc_block) {
    this.tc_block = tc_block;
  }

  public String getStream() {
    return stream;
  }

  public void setStream(String stream) {
    this.stream = stream;
  }

  public int[] getPids() {
    return pids;
  }

  public void setPids(int[] pids) {
    this.pids = pids;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}