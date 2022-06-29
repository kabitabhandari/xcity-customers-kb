package com.things.customer.xcitycustomerskb.Exception;

/**
 * This exception can be used when parameters and headers are invalid
 */
public class MapIsEmptyException extends RuntimeException {
    //TODO add serival version uid
    public MapIsEmptyException(String message) {
        super(message);
    }
}
