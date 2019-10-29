
package codetask.fds.model.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driverId",
    "permanentNumber",
    "code",
    "url",
    "givenName",
    "familyName",
    "dateOfBirth",
    "nationality"
})
public class Driver implements Serializable
{

    @JsonProperty("driverId")
    private String driverId;
    @JsonProperty("permanentNumber")
    private String permanentNumber;
    @JsonProperty("code")
    private String code;
    @JsonProperty("url")
    private String url;
    @JsonProperty("givenName")
    private String givenName;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("nationality")
    private String nationality;
    private final static long serialVersionUID = 6516024470882379701L;

    @JsonProperty("driverId")
    public String getDriverId() {
        return driverId;
    }

    @JsonProperty("driverId")
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @JsonProperty("permanentNumber")
    public String getPermanentNumber() {
        return permanentNumber;
    }

    @JsonProperty("permanentNumber")
    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("givenName")
    public String getGivenName() {
        return givenName;
    }

    @JsonProperty("givenName")
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @JsonProperty("familyName")
    public String getFamilyName() {
        return familyName;
    }

    @JsonProperty("familyName")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
