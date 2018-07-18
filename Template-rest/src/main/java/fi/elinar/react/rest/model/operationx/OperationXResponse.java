package fi.elinar.react.rest.model.operationx;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Operation X Response message
 * @author Mika Mähönen <mika.mahonen@elinar.fi>
 */
public class OperationXResponse {
        
        //Json property (message)
        @JsonProperty("message")
        private String message;

        /**
         * Sets Message
         * @param message 
         */
        @JsonProperty("message")
        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * Gets Message
         * @return message
         */
        @JsonProperty("message")
        public String getMessage() {
            return message;
        }

}
