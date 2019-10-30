
package codetask.fds.model.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rank",
    "lap",
    "Time",
    "AverageSpeed"
})
public class FastestLap implements Serializable
{

    @JsonProperty("rank")
    private String rank;
    @JsonProperty("lap")
    private String lap;
    @JsonProperty("Time")
    private Time_ time;
    @JsonProperty("AverageSpeed")
    private AverageSpeed averageSpeed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5859799259540107021L;

    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    @JsonProperty("lap")
    public String getLap() {
        return lap;
    }

    @JsonProperty("lap")
    public void setLap(String lap) {
        this.lap = lap;
    }

    @JsonProperty("Time")
    public Time_ getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(Time_ time) {
        this.time = time;
    }

    @JsonProperty("AverageSpeed")
    public AverageSpeed getAverageSpeed() {
        return averageSpeed;
    }

    @JsonProperty("AverageSpeed")
    public void setAverageSpeed(AverageSpeed averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
