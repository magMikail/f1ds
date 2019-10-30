package codetask.fds.model.response;

/**
 * Created by magMikail on 10/30/2019.
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentData {
    @JsonProperty("MRData")
    private MRData mrData;

    public MRData getMrData() {
        return mrData;
    }

    public void setMrData(MRData mrData) {
        this.mrData = mrData;
    }
}
