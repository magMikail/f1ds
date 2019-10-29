
package codetask.fds.model.response;

import java.io.Serializable;
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
    private final static long serialVersionUID = 6006827505553834312L;

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

}
