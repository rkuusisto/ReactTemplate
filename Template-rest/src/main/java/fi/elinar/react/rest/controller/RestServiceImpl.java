package fi.elinar.react.rest.controller;


import fi.elinar.react.rest.exception.AbstractException;
import fi.elinar.react.rest.model.ErrorMessage;
import fi.elinar.react.rest.model.Message;
import fi.elinar.react.rest.model.operationx.OperationXRequest;
import fi.elinar.react.rest.model.operationx.OperationXResponse;
import io.swagger.annotations.*;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.*;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@Scope("prototype")
@Api(value = "/api", description = "Rest Template",tags = {"Rest Template"})
public class RestServiceImpl extends AbstractService {

 
    private final Logger log = LoggerFactory.getLogger(RestServiceImpl.class);

    public RestServiceImpl() {
        log.debug("Execution {} begins",this.id);
    }

    @PostConstruct
    public void postCreate() {
     

    }

    /**
     * 
     * @param data
     * @param cookies
     * @param request
     * @param rs
     * @return 
     * @throws AbstractException 
     */
    @ApiOperation(value = "Operation X", 
            nickname="Operation X",
            notes = "Returns greeting message"
    
    )
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "OK"),
    @ApiResponse(code = 400, message = "Bad request",response=ErrorMessage.class),
    @ApiResponse(code = 401, message = "Not authorized",response=ErrorMessage.class),
    @ApiResponse(code = 500, message = "Internal server error",response=ErrorMessage.class)})
    @RequestMapping(value = "/api/operationx", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Message<OperationXResponse> operationX(
            @RequestBody OperationXRequest data,
            @RequestHeader(value = HttpHeaders.COOKIE, required = false) String cookies,
            HttpServletRequest request,
            HttpServletResponse rs
    )
        throws AbstractException {
        Message<OperationXResponse> message  = new Message<>();
        message.setTrackingId(id.toString());
        


        
        OperationXResponse response = new OperationXResponse();
        response.setMessage("Hello: "+data.getFirstName()+" "+data.getLastName());
        message.setPayload(response);
            
        log.info("Kikkelis kakkelis");
        return message;
    }      
    
    
}
