package codetask.fds.model.request.pitStops;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RacesResults implements Serializable {

    @JsonProperty("MRData")
    private MRData mRData;

    public MRData getmRData() {
        return mRData;
    }

    public void setmRData(MRData mRData) {
        this.mRData = mRData;
    }
}