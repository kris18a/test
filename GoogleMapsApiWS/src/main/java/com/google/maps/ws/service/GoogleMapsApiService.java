package com.google.maps.ws.service;

import com.google.maps.ws.model.PlaceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by X on 31/05/2016.
 */
public interface GoogleMapsApiService {
    PlaceResponse searchPlaces(String latitude, String longitude) throws IOException, URISyntaxException;
}
