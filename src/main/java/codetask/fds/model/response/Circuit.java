
package codetask.fds.model.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "circuitId",
    "url",
    "circuitName",
    "Location"
})
public class Circuit implements Serializable
{

    @JsonProperty("circuitId")
    private String circuitId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("circuitName")
    private String circuitName;
    @JsonProperty("Location")
    private Location location;
    private final static long serialVersionUID = -7639847481320535304L;

    @JsonProperty("circuitId")
    public String getCircuitId() {
        return circuitId;
    }

    @JsonProperty("circuitId")
    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("circuitName")
    public String getCircuitName() {
        return circuitName;
    }

    @JsonProperty("circuitName")
    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    @JsonProperty("Location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("Location")
    public void setLocation(Location location) {
        this.location = location;
    }

}
