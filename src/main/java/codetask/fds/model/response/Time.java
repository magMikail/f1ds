
package codetask.fds.model.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "millis",
    "time"
})
public class Time implements Serializable
{

    @JsonProperty("millis")
    private String millis;
    @JsonProperty("time")
    private String time;
    private final static long serialVersionUID = 2867906056829099021L;

    @JsonProperty("millis")
    public String getMillis() {
        return millis;
    }

    @JsonProperty("millis")
    public void setMillis(String millis) {
        this.millis = millis;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

}
