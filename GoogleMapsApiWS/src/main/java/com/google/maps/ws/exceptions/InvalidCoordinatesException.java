package com.google.maps.ws.exceptions;

/**
 * Created by X on 1/06/2016.
 */
public final class InvalidCoordinatesException extends Exception {
    /**
     * Default constructor.
     */
    public InvalidCoordinatesException() {
    }

    /**
     * Constructor with parameters.
     * @param message the message
     */
    public InvalidCoordinatesException(final String message) {
        super(message);
    }
}
