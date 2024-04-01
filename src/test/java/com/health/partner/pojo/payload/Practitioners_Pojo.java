package com.health.partner.pojo.payload;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
//@Data
//@Getter @Setter
@Builder
@Jacksonized //must use with builder otherwise jackson @ not going to work with lombook
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "practitionerIds",
        "slotLimit",
        "lng",
        "lat",
        "appointmentType"
})

public class Practitioners_Pojo {

    @JsonProperty("practitionerIds")
    List<Integer> practitionerIds;
    @JsonProperty("slotLimit")
    Integer slotLimit;
    @JsonProperty("lng")
    Double lng;
    @JsonProperty("lat")
    Double lat;
    @JsonProperty("appointmentType")
    Integer appointmentType;
    @JsonIgnore
    Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}