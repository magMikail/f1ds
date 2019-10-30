
package codetask.fds.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "season",
    "position",
    "Races"
})
public class RaceTable implements Serializable
{

    @JsonProperty("season")
    private String season;
    @JsonProperty("position")
    private String position;
    @JsonProperty("Races")
    private List<Race> races = new ArrayList<Race>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6511136144733567991L;

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
