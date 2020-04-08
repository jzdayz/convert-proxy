package io.github.jzdayz.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.github.jzdayz.model.Proxy;
import io.github.jzdayz.model.ProxyGroup;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "port",
        "socks-port",
        "allow-lan",
        "mode",
        "log-level",
        "external-controller",
        "Proxy",
        "Proxy Group",
        "Rule"
})
@Data
public class YamlData {

    @JsonProperty("port")
    public Integer port;
    @JsonProperty("socks-port")
    public Integer socksPort;
    @JsonProperty("allow-lan")
    public Boolean allowLan;
    @JsonProperty("mode")
    public String mode;
    @JsonProperty("log-level")
    public String logLevel;
    @JsonProperty("external-controller")
    public String externalController;
    @JsonProperty("Proxy")
    public List<Proxy> proxy = null;
    @JsonProperty("Proxy Group")
    public List<ProxyGroup> proxyGroup = null;
    @JsonProperty("Rule")
    public List<String> rule = null;

}