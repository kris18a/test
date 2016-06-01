package com.google.maps.ws.service;

import com.google.maps.ws.model.PlaceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by X on 31/05/2016.
 */
public interface GoogleMapsApiService {
    /**
     * Search for places of specific type on Google Maps based on provided latitude and longitude on a 1000m radius.
     * @param placeType placetype eg:restaurant, food, hotel, etc https://developers.google.com/places/supported_types#table1
     * @param latitude latitude
     * @param longitude longitude
     * @return PlaceResponse object containing list of places
     * @throws IOException Exception
     * @throws URISyntaxException Exception
     */
    PlaceResponse searchPlaces(String placeType, String latitude, String longitude) throws IOException, URISyntaxException;
}
