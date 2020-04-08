package io.github.jzdayz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "type",
        "proxies",
        "url",
        "interval"
})
@Data
public class ProxyGroup {

    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("proxies")
    public List<String> proxies = null;
    @JsonProperty("url")
    public String url;
    @JsonProperty("interval")
    public Integer interval;

}