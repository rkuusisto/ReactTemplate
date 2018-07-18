package fi.elinar.react.rest.model.operationx;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Operation X Request
 * @author Mika Mähönen <mika.mahonen@elinar.fi>
 */
public class OperationXRequest {
    //Json property (message)

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
