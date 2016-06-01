package com.google.maps.ws.service;

import com.google.maps.ws.model.PlaceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 31/05/2016.
 */
@Service("googleMapsApiService")
public class GoogleMapsApiServiceImpl implements GoogleMapsApiService {

    @Autowired
    @Qualifier("googleApiBaseUrl")
    private String url;

    @Autowired
    @Qualifier("googleApiKey")
    private String apiKey;

    @Override
    public PlaceResponse searchPlaces(String latitude, String longitude) throws IOException, URISyntaxException {
        final MessageFormat mFormat = new MessageFormat(getUrl());
        final Object[] params = {latitude, longitude, getApiKey()};
        final URI uri = new URI(mFormat.format(params));

        final RestTemplate tmpl = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        tmpl.setMessageConverters(converters);
        PlaceResponse response = tmpl.getForObject(uri, PlaceResponse.class);

        System.out.println(response);
        return response;
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
