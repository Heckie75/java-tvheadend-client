package de.heckie.tvheadend.api.model.dvr;

import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DvrEntry {

  private String uuid;
  private boolean enabled;
  private long create;
  private int watched;
  private long start;
  private long start_extra;
  private long start_real;
  private long stop;
  private long stop_extra;
  private long stop_real;
  private long duration;
  private String channel;
  private String channelname;
  private String image;
  private String fanart_image;
  private String disp_title;
  private String disp_subtitle;
  private String disp_summary;
  private String disp_description;
  private String disp_extratext;
  private String config_name;
  private String creator;
  private String filename;
  private String autorec_caption;
  private String autorec;
  private String timerec;
  private String timerec_caption;
  private String parent;
  private String child;
  private String episode_disp;
  private String url;
  private String status;
  private String sched_status;
  private int pri;
  private int retention;
  private long removal;
  private long playposition;
  private int playcount;
  private int errorcode;
  private long errors;
  private long data_errors;
  private long dvb_eid;
  private long fileremoved;
  private int content_type;
  private int copyright_year;
  private long broadcast;
  private long filesize;
  private int duplicate;
  private int first_aired;
  private boolean noresched;
  private boolean norerecord;
  private Map<String, String> title;
  private Map<String, String> subtitle;
  private Map<String, String> description;
  private String[] keyword;
  private int[] genre;
  private String comment;
  private Object credits; // TODO
  private Object[] category; // TODO

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public long getCreate() {
    return create;
  }

  public void setCreate(long create) {
    this.create = create;
  }

  public int getWatched() {
    return watched;
  }

  public void setWatched(int watched) {
    this.watched = watched;
  }

  public long getStart() {
    return start;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public long getStart_extra() {
    return start_extra;
  }

  public void setStart_extra(long start_extra) {
    this.start_extra = start_extra;
  }

  public long getStart_real() {
    return start_real;
  }

  public void setStart_real(long start_real) {
    this.start_real = start_real;
  }

  public long getStop() {
    return stop;
  }

  public void setStop(long stop) {
    this.stop = stop;
  }

  public long getStop_extra() {
    return stop_extra;
  }

  public void setStop_extra(long stop_extra) {
    this.stop_extra = stop_extra;
  }

  public long getStop_real() {
    return stop_real;
  }

  public void setStop_real(long stop_real) {
    this.stop_real = stop_real;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getChannelname() {
    return channelname;
  }

  public void setChannelname(String channelname) {
    this.channelname = channelname;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getFanart_image() {
    return fanart_image;
  }

  public void setFanart_image(String fanart_image) {
    this.fanart_image = fanart_image;
  }

  public String getDisp_title() {
    return disp_title;
  }

  public void setDisp_title(String disp_title) {
    this.disp_title = disp_title;
  }

  public String getDisp_subtitle() {
    return disp_subtitle;
  }

  public void setDisp_subtitle(String disp_subtitle) {
    this.disp_subtitle = disp_subtitle;
  }

  public String getDisp_summary() {
    return disp_summary;
  }

  public void setDisp_summary(String disp_summary) {
    this.disp_summary = disp_summary;
  }

  public String getDisp_description() {
    return disp_description;
  }

  public void setDisp_description(String disp_description) {
    this.disp_description = disp_description;
  }

  public String getDisp_extratext() {
    return disp_extratext;
  }

  public void setDisp_extratext(String disp_extratext) {
    this.disp_extratext = disp_extratext;
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

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getAutorec_caption() {
    return autorec_caption;
  }

  public void setAutorec_caption(String autorec_caption) {
    this.autorec_caption = autorec_caption;
  }

  public String getAutorec() {
    return autorec;
  }

  public void setAutorec(String autorec) {
    this.autorec = autorec;
  }

  public String getTimerec() {
    return timerec;
  }

  public void setTimerec(String timerec) {
    this.timerec = timerec;
  }

  public String getTimerec_caption() {
    return timerec_caption;
  }

  public void setTimerec_caption(String timerec_caption) {
    this.timerec_caption = timerec_caption;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getChild() {
    return child;
  }

  public void setChild(String child) {
    this.child = child;
  }

  public String getEpisode_disp() {
    return episode_disp;
  }

  public void setEpisode_disp(String episode_disp) {
    this.episode_disp = episode_disp;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSched_status() {
    return sched_status;
  }

  public void setSched_status(String sched_status) {
    this.sched_status = sched_status;
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

  public long getRemoval() {
    return removal;
  }

  public void setRemoval(long removal) {
    this.removal = removal;
  }

  public long getPlayposition() {
    return playposition;
  }

  public void setPlayposition(long playposition) {
    this.playposition = playposition;
  }

  public int getPlaycount() {
    return playcount;
  }

  public void setPlaycount(int playcount) {
    this.playcount = playcount;
  }

  public int getErrorcode() {
    return errorcode;
  }

  public void setErrorcode(int errorcode) {
    this.errorcode = errorcode;
  }

  public long getErrors() {
    return errors;
  }

  public void setErrors(long errors) {
    this.errors = errors;
  }

  public long getData_errors() {
    return data_errors;
  }

  public void setData_errors(long data_errors) {
    this.data_errors = data_errors;
  }

  public long getDvb_eid() {
    return dvb_eid;
  }

  public void setDvb_eid(long dvb_eid) {
    this.dvb_eid = dvb_eid;
  }

  public long getFileremoved() {
    return fileremoved;
  }

  public void setFileremoved(long fileremoved) {
    this.fileremoved = fileremoved;
  }

  public int getContent_type() {
    return content_type;
  }

  public void setContent_type(int content_type) {
    this.content_type = content_type;
  }

  public int getCopyright_year() {
    return copyright_year;
  }

  public void setCopyright_year(int copyright_year) {
    this.copyright_year = copyright_year;
  }

  public long getBroadcast() {
    return broadcast;
  }

  public void setBroadcast(long broadcast) {
    this.broadcast = broadcast;
  }

  public long getFilesize() {
    return filesize;
  }

  public void setFilesize(long filesize) {
    this.filesize = filesize;
  }

  public int getDuplicate() {
    return duplicate;
  }

  public void setDuplicate(int duplicate) {
    this.duplicate = duplicate;
  }

  public int getFirst_aired() {
    return first_aired;
  }

  public void setFirst_aired(int first_aired) {
    this.first_aired = first_aired;
  }

  public boolean isNoresched() {
    return noresched;
  }

  public void setNoresched(boolean noresched) {
    this.noresched = noresched;
  }

  public boolean isNorerecord() {
    return norerecord;
  }

  public void setNorerecord(boolean norerecord) {
    this.norerecord = norerecord;
  }

  public Map<String, String> getTitle() {
    return title;
  }

  public void setTitle(Map<String, String> title) {
    this.title = title;
  }

  public Map<String, String> getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(Map<String, String> subtitle) {
    this.subtitle = subtitle;
  }

  public Map<String, String> getDescription() {
    return description;
  }

  public void setDescription(Map<String, String> description) {
    this.description = description;
  }

  public Object getCredits() {
    return credits;
  }

  public void setCredits(Object credits) {
    this.credits = credits;
  }

  public Object[] getCategory() {
    return category;
  }

  public void setCategory(Object[] category) {
    this.category = category;
  }

  public String[] getKeyword() {
    return keyword;
  }

  public void setKeyword(String[] keyword) {
    this.keyword = keyword;
  }

  public int[] getGenre() {
    return genre;
  }

  public void setGenre(int[] genre) {
    this.genre = genre;
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
