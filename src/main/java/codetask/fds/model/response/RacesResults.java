
package codetask.fds.model.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MRData"
})
public class RacesResults implements Serializable
{

    @JsonProperty("MRData")
    private MRData mRData;
    private final static long serialVersionUID = -275715174223119205L;

    @JsonProperty("MRData")
    public MRData getMRData() {
        return mRData;
    }

    @JsonProperty("MRData")
    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }

}
