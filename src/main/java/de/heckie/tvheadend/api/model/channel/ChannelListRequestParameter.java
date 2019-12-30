package de.heckie.tvheadend.api.model.channel;

import java.util.HashMap;
import java.util.Map;

import de.heckie.tvheadend.api.model.AbstractParams;

public class ChannelListRequestParameter extends AbstractParams {

  private Integer all = 1;

  private Integer numbers = 0;

  public Integer getAll() {
    return all;
  }

  public void setAll(Integer all) {
    this.all = all;
  }

  public Integer getNumbers() {
    return numbers;
  }

  public void setNumbers(Integer numbers) {
    this.numbers = numbers;
  }

  @Override
  public Map<String, String> toMap() {
    HashMap<String, String> map = new HashMap<>();
    map.putAll(Map.of("all", all != null ? String.valueOf(all) : "",
        "numbers", numbers != null ? String.valueOf(numbers) : ""));
    return map;
  }
}
