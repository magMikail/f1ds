
package codetask.fds.model.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "season",
    "round",
    "url",
    "raceName",
    "Circuit",
    "date",
    "time",
    "Results"
})
public class Race implements Serializable
{

    @JsonProperty("season")
    private String season;
    @JsonProperty("round")
    private String round;
    @JsonProperty("url")
    private String url;
    @JsonProperty("raceName")
    private String raceName;
    @JsonProperty("Circuit")
    private Circuit circuit;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;
    @JsonProperty("Results")
    private List<Result> results = new ArrayList<>();
    private final static long serialVersionUID = -558820549159597510L;

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("round")
    public String getRound() {
        return round;
    }

    @JsonProperty("round")
    public void setRound(String round) {
        this.round = round;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("raceName")
    public String getRaceName() {
        return raceName;
    }

    @JsonProperty("raceName")
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @JsonProperty("Circuit")
    public Circuit getCircuit() {
        return circuit;
    }

    @JsonProperty("Circuit")
    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("Results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("Results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
