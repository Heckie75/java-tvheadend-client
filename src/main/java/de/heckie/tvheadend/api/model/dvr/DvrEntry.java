package de.heckie.tvheadend.api.model.dvr;

import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DvrEntry {

  private String uuid;
  private Boolean enabled;
  private Long create;
  private Integer watched;
  private Long start;
  private Long start_extra;
  private Long start_real;
  private Long stop;
  private Long stop_extra;
  private Long stop_real;
  private Long duration;
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
  private String owner;
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
  private Integer pri;
  private Integer retention;
  private Long removal;
  private Long playposition;
  private Integer playcount;
  private Integer errorcode;
  private Long errors;
  private Long data_errors;
  private Long dvb_eid;
  private Long fileremoved;
  private Integer content_type;
  private Integer copyright_year;
  private Long broadcast;
  private Long filesize;
  private Integer duplicate;
  private Integer first_aired;
  private Boolean noresched;
  private Boolean norerecord;
  private Map<String, String> title;
  private Map<String, String> subtitle;
  private Map<String, String> description;
  private String[] keyword;
  private Integer[] genre;
  private String comment;
  private Object credits;
  private Object[] category;

  public DvrEntry() {
  }

  public DvrEntry(boolean enabled, String disp_title, String disp_extratext, String channel, long start, long stop,
      String comment, String episode_disp, long start_extra, long stop_extra, int pri, String config_name, String owner,
      String creator, long removal, int retention, String uuid) {
    this.enabled = Boolean.valueOf(enabled);
    this.disp_title = disp_title;
    this.disp_extratext = disp_extratext;
    this.channel = channel;
    this.start = Long.valueOf(start);
    this.stop = Long.valueOf(stop);
    this.comment = comment;
    this.episode_disp = episode_disp;
    this.start_extra = Long.valueOf(start_extra);
    this.stop_extra = Long.valueOf(stop_extra);
    this.pri = Integer.valueOf(pri);
    this.config_name = config_name;
    this.owner = owner;
    this.creator = creator;
    this.removal = Long.valueOf(removal);
    this.retention = Integer.valueOf(retention);
    this.uuid = uuid;
  }

  public static DvrEntry of(DvrEntry o) {
    DvrEntry dvrEntry = new DvrEntry();
    dvrEntry.enabled = o.enabled;
    dvrEntry.disp_title = o.disp_title;
    dvrEntry.disp_extratext = o.disp_extratext;
    dvrEntry.channel = o.channel;
    dvrEntry.start = o.start;
    dvrEntry.stop = o.stop;
    dvrEntry.comment = o.comment;
    dvrEntry.episode_disp = o.episode_disp;
    dvrEntry.start_extra = o.start_extra;
    dvrEntry.stop_extra = o.stop_extra;
    dvrEntry.pri = o.pri;
    dvrEntry.config_name = o.config_name;
    dvrEntry.owner = o.owner;
    dvrEntry.creator = o.creator;
    dvrEntry.removal = o.removal;
    dvrEntry.retention = o.retention;
    dvrEntry.uuid = o.uuid;
    return dvrEntry;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Long getCreate() {
    return create;
  }

  public void setCreate(Long create) {
    this.create = create;
  }

  public Integer getWatched() {
    return watched;
  }

  public void setWatched(Integer watched) {
    this.watched = watched;
  }

  public Long getStart() {
    return start;
  }

  public void setStart(Long start) {
    this.start = start;
  }

  public Long getStart_extra() {
    return start_extra;
  }

  public void setStart_extra(Long start_extra) {
    this.start_extra = start_extra;
  }

  public Long getStart_real() {
    return start_real;
  }

  public void setStart_real(Long start_real) {
    this.start_real = start_real;
  }

  public Long getStop() {
    return stop;
  }

  public void setStop(Long stop) {
    this.stop = stop;
  }

  public Long getStop_extra() {
    return stop_extra;
  }

  public void setStop_extra(Long stop_extra) {
    this.stop_extra = stop_extra;
  }

  public Long getStop_real() {
    return stop_real;
  }

  public void setStop_real(Long stop_real) {
    this.stop_real = stop_real;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
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

  public Integer getPri() {
    return pri;
  }

  public void setPri(Integer pri) {
    this.pri = pri;
  }

  public Integer getRetention() {
    return retention;
  }

  public void setRetention(Integer retention) {
    this.retention = retention;
  }

  public Long getRemoval() {
    return removal;
  }

  public void setRemoval(Long removal) {
    this.removal = removal;
  }

  public Long getPlayposition() {
    return playposition;
  }

  public void setPlayposition(Long playposition) {
    this.playposition = playposition;
  }

  public Integer getPlaycount() {
    return playcount;
  }

  public void setPlaycount(Integer playcount) {
    this.playcount = playcount;
  }

  public Integer getErrorcode() {
    return errorcode;
  }

  public void setErrorcode(Integer errorcode) {
    this.errorcode = errorcode;
  }

  public Long getErrors() {
    return errors;
  }

  public void setErrors(Long errors) {
    this.errors = errors;
  }

  public Long getData_errors() {
    return data_errors;
  }

  public void setData_errors(Long data_errors) {
    this.data_errors = data_errors;
  }

  public Long getDvb_eid() {
    return dvb_eid;
  }

  public void setDvb_eid(Long dvb_eid) {
    this.dvb_eid = dvb_eid;
  }

  public Long getFileremoved() {
    return fileremoved;
  }

  public void setFileremoved(Long fileremoved) {
    this.fileremoved = fileremoved;
  }

  public Integer getContent_type() {
    return content_type;
  }

  public void setContent_type(Integer content_type) {
    this.content_type = content_type;
  }

  public Integer getCopyright_year() {
    return copyright_year;
  }

  public void setCopyright_year(Integer copyright_year) {
    this.copyright_year = copyright_year;
  }

  public Long getBroadcast() {
    return broadcast;
  }

  public void setBroadcast(Long broadcast) {
    this.broadcast = broadcast;
  }

  public Long getFilesize() {
    return filesize;
  }

  public void setFilesize(Long filesize) {
    this.filesize = filesize;
  }

  public Integer getDuplicate() {
    return duplicate;
  }

  public void setDuplicate(Integer duplicate) {
    this.duplicate = duplicate;
  }

  public Integer getFirst_aired() {
    return first_aired;
  }

  public void setFirst_aired(Integer first_aired) {
    this.first_aired = first_aired;
  }

  public Boolean isNoresched() {
    return noresched;
  }

  public void setNoresched(Boolean noresched) {
    this.noresched = noresched;
  }

  public Boolean isNorerecord() {
    return norerecord;
  }

  public void setNorerecord(Boolean norerecord) {
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

  public Integer[] getGenre() {
    return genre;
  }

  public void setGenre(Integer[] genre) {
    this.genre = genre;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public Boolean getNoresched() {
    return noresched;
  }

  public Boolean getNorerecord() {
    return norerecord;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
