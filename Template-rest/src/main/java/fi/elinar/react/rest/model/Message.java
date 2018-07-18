package fi.elinar.react.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;

/**
 * Example Response
 * @author Mika Mähönen
 * @param <E>
 */
public class Message<E> {
    //Identification
    @JsonProperty("trackingId")
    private String trackingId;

    //Example, How to date-time with time zone
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    @JsonProperty("time")
    private Calendar time = Calendar.getInstance();

    @JsonProperty("payload")
    private E payload;

 

    public E getPayload() {
        return payload;
    }


    @JsonProperty("payload")
    public void setPayload(E payload) {
        this.payload = payload;
    }
 
    @JsonProperty("trackingId")
    public void setTrackingId(String identification) {
        this.trackingId = identification;
    }

    @JsonProperty("trackingId")
    public String getTrackingId() {
        return trackingId;
    }
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")

    public void setTime(Calendar time) {
        this.time = time;
    }
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
    public Calendar getTime() {
        return time;
    }

}
