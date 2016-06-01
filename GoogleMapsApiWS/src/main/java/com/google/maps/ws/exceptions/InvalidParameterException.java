package com.google.maps.ws.exceptions;

/**
 * Exception thrown when one of the webservice parameters are invalid (coordinates or placeType).
 * Created by X on 1/06/2016.
 */
public final class InvalidParameterException extends RuntimeException {
    /**
     * Default constructor.
     */
    public InvalidParameterException() {
    }

    /**
     * Constructor with parameters.
     * @param message the message
     */
    public InvalidParameterException(final String message) {
        super(message);
    }
}
