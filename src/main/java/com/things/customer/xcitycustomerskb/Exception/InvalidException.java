package com.things.customer.xcitycustomerskb.Exception;

/**
 * This exception can be used when parameters and headers are invalid
 */
public class InvalidException extends RuntimeException {
    //TODO add serival version uid
    public InvalidException(String message) {
        super(message);
    }
}
