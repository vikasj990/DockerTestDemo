package com.iceye.sbdb.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Signature {

    @JsonProperty("source")
    String source;

    @JsonProperty("version")
    String version;
}
