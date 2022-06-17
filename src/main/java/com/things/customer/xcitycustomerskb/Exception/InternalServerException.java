package com.things.customer.xcitycustomerskb.Exception;

/**
 * This exception can be used when parameters and headers are invalid
 */
public class InternalServerException extends RuntimeException {
    //TODO add serival version uid
    public InternalServerException(String message) {
        super(message);
    }
}
