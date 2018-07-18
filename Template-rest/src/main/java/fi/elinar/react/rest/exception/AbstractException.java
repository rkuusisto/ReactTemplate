/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.exception;

/**
 * Abstract EDS Service Exception
 * @author Mika Mähönen
 */
public class AbstractException extends Exception{
    private final Object[] arguments;
    private final String messageCode;

    public AbstractException(Object[] arguments, String messageCode, String message) {
        super(message);
        this.arguments = arguments;
        this.messageCode = messageCode;
    }

        
        
    public AbstractException(Object[] arguments, String messageCode, String message, Throwable cause) {
        super(message, cause);
        this.arguments = arguments;
        this.messageCode = messageCode;
    }

        public String getMessageCode() {
            return messageCode;
        }

        public Object[] getArguments() {
            return arguments;
        }

        
        
}
