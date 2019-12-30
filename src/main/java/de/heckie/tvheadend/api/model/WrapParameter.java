package de.heckie.tvheadend.api.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WrapParameter extends AbstractParams {

  private final String paramName;
  private final Object object;

  public WrapParameter(String paramName, Object object) {
    this.paramName = paramName;
    this.object = object;
  }

  @Override
  public Map<String, String> toMap() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(Include.NON_NULL);

    HashMap<String, String> map = new HashMap<>();
    try {
      String value = objectMapper.writeValueAsString(object);
      map.putAll(Map.of(paramName, value));
    } catch (JsonProcessingException e) {
      // no op
    }

    return map;
  }

}
