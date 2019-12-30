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

  public TimeRecEntry(boolean enabled, String name, String channel, String start, String stop, int[] weekdays, String comment,
      String title, String config_name, String owner, String creator, int pri, long removal, String directory, int retention,
      String uuid) {

    this.enabled = Boolean.valueOf(enabled);
    this.name = name;
    this.channel = channel;
    this.start = start;
    this.stop = stop;
    this.weekdays = weekdays;
    this.comment = comment;
    this.title = title;
    this.config_name = config_name;
    this.owner = owner;
    this.creator = creator;
    this.pri = pri;
    this.removal = Long.valueOf(removal);
    this.directory = directory;
    this.retention = Integer.valueOf(retention);
    this.uuid = uuid;
  }

  public static TimeRecEntry of(TimeRecEntry o) {
    TimeRecEntry timeRecEntry = new TimeRecEntry();
    timeRecEntry.enabled = o.enabled;
    timeRecEntry.name = o.name;
    timeRecEntry.channel = o.channel;
    timeRecEntry.start = o.start;
    timeRecEntry.stop = o.stop;
    timeRecEntry.weekdays = o.weekdays;
    timeRecEntry.comment = o.comment;
    timeRecEntry.title = o.title;
    timeRecEntry.config_name = o.config_name;
    timeRecEntry.owner = o.owner;
    timeRecEntry.creator = o.creator;
    timeRecEntry.pri = o.pri;
    timeRecEntry.removal = o.removal;
    timeRecEntry.directory = o.directory;
    timeRecEntry.retention = o.retention;
    timeRecEntry.uuid = o.uuid;
    return timeRecEntry;
  }

}
