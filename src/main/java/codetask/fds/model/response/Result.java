
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
    "number",
    "position",
    "positionText",
    "points",
    "Driver",
    "Constructor",
    "grid",
    "laps",
    "status",
    "Time",
    "FastestLap"
})
public class Result implements Serializable
{

    @JsonProperty("number")
    private String number;
    @JsonProperty("position")
    private String position;
    @JsonProperty("positionText")
    private String positionText;
    @JsonProperty("points")
    private String points;
    @JsonProperty("Driver")
    private Driver driver;
    @JsonProperty("Constructor")
    private Constructor constructor;
    @JsonProperty("grid")
    private String grid;
    @JsonProperty("laps")
    private String laps;
    @JsonProperty("status")
    private String status;
    @JsonProperty("Time")
    private Time time;
    @JsonProperty("FastestLap")
    private FastestLap fastestLap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6300657953601144343L;

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("positionText")
    public String getPositionText() {
        return positionText;
    }

    @JsonProperty("positionText")
    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    @JsonProperty("points")
    public String getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(String points) {
        this.points = points;
    }

    @JsonProperty("Driver")
    public Driver getDriver() {
        return driver;
    }

    @JsonProperty("Driver")
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @JsonProperty("Constructor")
    public Constructor getConstructor() {
        return constructor;
    }

    @JsonProperty("Constructor")
    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    @JsonProperty("grid")
    public String getGrid() {
        return grid;
    }

    @JsonProperty("grid")
    public void setGrid(String grid) {
        this.grid = grid;
    }

    @JsonProperty("laps")
    public String getLaps() {
        return laps;
    }

    @JsonProperty("laps")
    public void setLaps(String laps) {
        this.laps = laps;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(Time time) {
        this.time = time;
    }

    @JsonProperty("FastestLap")
    public FastestLap getFastestLap() {
        return fastestLap;
    }

    @JsonProperty("FastestLap")
    public void setFastestLap(FastestLap fastestLap) {
        this.fastestLap = fastestLap;
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
