package codetask.fds.model.request.pitStops;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PitStop implements Serializable {

    @JsonProperty("driverId")
    private String driverId;

    @JsonProperty("duration")
    private String duration;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "{" +
                "driverId='" + driverId + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}