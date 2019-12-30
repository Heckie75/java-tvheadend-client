package de.heckie.tvheadend.api.model.dvr;

public class TimeRecEntry extends AbstractRecEntry {

  private String stop;

  public String getStop() {
    return stop;
  }

  public void setStop(String stop) {
    this.stop = stop;
  }

  public TimeRecEntry() {
  }

  public TimeRecEntry(String name, String channel, String start, String stop, int[] weekdays, String comment, String title,
      String configName, String directory) {
    this.name = name;
    this.channel = channel;
    this.start = start;
    this.stop = stop;
    this.weekdays = weekdays;
    this.comment = comment;
    this.title = title;
    this.config_name = configName;
    this.directory = directory;
  }

}
