package com.google.maps.ws.util;

import com.google.maps.ws.exceptions.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by X on 1/06/2016.
 */
public class UtilitiesTest {
    @Test
    public void testGoodCoordinates() throws Exception {
        Utilities.validateCoordinate("1.1");
        Utilities.validateCoordinate("3.0");
        Assert.assertTrue(true);
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void testInvalidCoordinatesNoDot() throws Exception {
        Utilities.validateCoordinate("1");
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void testInvalidCoordinatesDot() throws Exception {
        Utilities.validateCoordinate("1.");
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void testInvalidCoordinatesTooBigValue() throws Exception {
        Utilities.validateCoordinate("1000.0");
    }

    @Test(expected = InvalidCoordinatesException.class)
    public void testInvalidCoordinatesString() throws Exception {
        Utilities.validateCoordinate("X");
    }
}
