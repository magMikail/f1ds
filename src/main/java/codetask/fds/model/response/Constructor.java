
package codetask.fds.model.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "constructorId",
    "url",
    "name",
    "nationality"
})
public class Constructor implements Serializable
{

    @JsonProperty("constructorId")
    private String constructorId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nationality")
    private String nationality;
    private final static long serialVersionUID = -5832619302563354920L;

    @JsonProperty("constructorId")
    public String getConstructorId() {
        return constructorId;
    }

    @JsonProperty("constructorId")
    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
