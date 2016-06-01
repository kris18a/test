package com.google.maps.ws.exceptions;

/**
 * Exception thrown when one of the config values is invalid.
 * Created by X on 1/06/2016.
 */
public class InvalidConfigurationException extends RuntimeException {
    /**
     * Default constructor.
     */
    public InvalidConfigurationException() {
    }

    /**
     * Constructor with parameters.
     * @param message the message
     */
    public InvalidConfigurationException(final String message) {
        super(message);
    }
}
