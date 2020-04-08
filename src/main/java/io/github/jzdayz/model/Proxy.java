package io.github.jzdayz.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "server",
        "port",
        "type",
        "cipher",
        "password"
})
@Data
public class Proxy {

    @JsonProperty("name")
    public String name;
    @JsonProperty("server")
    public String server;
    @JsonProperty("port")
    public Integer port;
    @JsonProperty("type")
    public String type;
    @JsonProperty("cipher")
    public String cipher;
    @JsonProperty("password")
    public String password;

}