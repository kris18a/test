package com.google.maps.ws.util;

import com.google.maps.ws.exceptions.InvalidCoordinatesException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by X on 1/06/2016.
 */
public final class Utilities {

    /**
     * Private constructor for utilities class.
     */
    private Utilities() {
    }

    /**
     * Validate that the String value is a valid coordinate.
     * @param coordinate the coordinate (latitude or longitude)
     * @throws InvalidCoordinatesException if the coordinate is not valid
     */
    public static void validateCoordinate(String coordinate) throws InvalidCoordinatesException {
        String regex_coords = "-?[1-9]{1}[0-9]{0,2}[.][0-9]+";
        Pattern compiledPattern = Pattern.compile(regex_coords, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(coordinate);
        if (!matcher.find()) {
            throw new InvalidCoordinatesException(
                    String.format("Coordinate %s provided is not a valid latitude/longiture value.", coordinate));
        }
    }
}
