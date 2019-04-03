package codekraken.jsonparser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(value="user_id")
    private String id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String country;

    @JsonProperty("address")
    private void unpackAddress(Map<String,Object> address){
        this.city = (String) address.get("City");
        this.country = (String) address.get("Country");
        this.street = (String) address.get("Street");
    }
}
