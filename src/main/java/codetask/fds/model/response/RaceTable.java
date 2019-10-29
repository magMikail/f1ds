package codetask.fds.model.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "season",
        "position",
        "Races"
})
public class RaceTable implements Serializable {

    private final static long serialVersionUID = -398347780963990872L;
    @JsonProperty("season")
    private String season;
    @JsonProperty("position")
    private String position;
    @JsonProperty("Races")
    private List<Race> races = null;

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("Races")
    public List<Race> getRaces() {
        return races;
    }

    @JsonProperty("Races")
    public void setRaces(List<Race> races) {
        this.races = races;
    }

}
