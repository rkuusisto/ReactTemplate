/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.controller;

import fi.elinar.react.rest.exception.*;
import fi.elinar.react.rest.model.ErrorMessage;
import java.util.Locale;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Mika Mähönen <mika.mahonen@elinar.fi>
 */
public abstract class AbstractService implements ApplicationContextAware {
    protected ApplicationContext ctx;
    protected final UUID id = UUID.randomUUID();
    private final Logger log = LoggerFactory.getLogger(AbstractService.class);
    
    @Autowired
    protected Locale locale;

    
    
    /**
     * Try to get error message
     * @param messageCode message code
     * @param data 
     * @return 
     */
    protected String getMessage(String messageCode, Object[] data) {
        try {
            return ctx.getMessage(messageCode, data, locale);
        } catch (Exception e) {

        }

        return "Not available";
    }
 

    /**
     * Error handler for Internal Server Error
     * @param req
     * @param exception
     * @return 
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerException.class)
    public ErrorMessage handleError(HttpServletRequest req, InternalServerException exception) {
        log.info("ERROR TrackingId: {}", id);
        log.info("Reason: {}", exception.getMessage());
        log.error("Stack: {}", exception);
        ErrorMessage message = new ErrorMessage();
        message.setErrorCode(exception.getMessageCode());
        message.setReason(this.getMessage(exception.getMessageCode(), exception.getArguments()));
        message.setTrackingId(id.toString());

        return message;
    }
   
  
     /**
     * Implements Application Context Aware
     *
     * @param ac
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ctx = ac;
    }


   
}
