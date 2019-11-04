package codetask.fds.model.request.pitStops;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Race implements Serializable {

    @JsonProperty("PitStops")
    private List<PitStop> pitStops = new ArrayList<PitStop>();

    public List<PitStop> getPitStops() {
        return pitStops;
    }

    public void setPitStops(List<PitStop> pitStops) {
        this.pitStops = pitStops;
    }
}