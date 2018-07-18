/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.elinar.react.rest.exception;

/**
 * Internal Server Error
 * @author Mika Mähönen
 */
public class InternalServerException extends AbstractException{

    public InternalServerException(Object[] arguments, String messageCode, String message) {
        super(arguments, messageCode, message);
    }

    public InternalServerException(Object[] arguments, String messageCode, String message, Throwable cause) {
        super(arguments, messageCode, message, cause);
    }
    
}
