package fi.elinar.react.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

/**
 * Error Message
 * Provides details about error
 * @author Mika Mähönen
 */
public class ErrorMessage {
    
    //Unique code
    @JsonProperty("errorCode")
    private String errorCode;
    
    //Error reason 
    @JsonProperty("reason")
    private String reason;
   
    //Identification
    @JsonProperty("trackingId")
    private String trackingId;

    //Example, How to date-time with time zone
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    @JsonProperty("time")
    private Calendar time = Calendar.getInstance();


    /**
     * Sets Error code
     * @param errorCode error code 
     */
    @JsonProperty("errorCode")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets Error code
     * @return error code
     */
    @JsonProperty("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Gets Reason why error occurred
     * @return reason
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }
    
    /**
     * Sets Reason why error occurred
     * @param reason Reason why error occurred
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    /**
     * Sets Tracking id
     * @param identification execution unique id 
     */
    @JsonProperty("trackingId")
    public void setTrackingId(String identification) {
        this.trackingId = identification;
    }

    /**
     * Gets unique id of execution
     * @return trackingId Tracking id
     */
    @JsonProperty("trackingId")
    public String getTrackingId() {
        return trackingId;
    }
    
    /**
     * Sets time error occurred
     * @param time time when error occurred
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    @JsonProperty("time")
    public void setTime(Calendar time) {
        this.time = time;
    }
    
    /**
     * Gets time when error occurred
     * @return time when error occurred
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    public Calendar getTime() {
        return time;
    }
    
    
}
