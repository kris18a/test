package com.google.maps.ws.controller;

import com.google.maps.ws.exceptions.InvalidCoordinatesException;
import com.google.maps.ws.model.PlaceResponse;
import com.google.maps.ws.service.GoogleMapsApiService;
import com.google.maps.ws.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by X on 31/05/2016.
 */
@RestController
public class GoogleMapsApiController {

    private static final Logger LOG = LogManager.getLogger(GoogleMapsApiController.class);

    @Autowired
    private GoogleMapsApiService googleMapsApiService;

    @RequestMapping(value = "/searchPlaces", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity searchPlaces(@RequestParam(defaultValue = "43.768353") String latitude,
                                       @RequestParam(defaultValue = "-79.4130463") String longitude) {
        try {
            Utilities.validateCoordinate(latitude);
            Utilities.validateCoordinate(longitude);
            final PlaceResponse pr = googleMapsApiService.searchPlaces(latitude, longitude);
            return ResponseEntity.ok(pr);
        } catch (InvalidCoordinatesException ex) {
            LOG.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(ex.getMessage());
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            return new ResponseEntity<PlaceResponse>(HttpStatus.BAD_REQUEST);
        }
    }
}
