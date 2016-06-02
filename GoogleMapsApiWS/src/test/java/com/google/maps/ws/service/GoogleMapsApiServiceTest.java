package com.google.maps.ws.service;

import com.google.maps.ws.exceptions.InvalidConfigurationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by X on 1/06/2016.
 */
public class GoogleMapsApiServiceTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    private GoogleMapsApiServiceImpl service = Mockito.mock(GoogleMapsApiServiceImpl.class);
    @Test
    public void testInvalidUri() throws IOException, URISyntaxException {
        expectedEx.expect(InvalidConfigurationException.class);
        expectedEx.expectMessage("URL in configuration file is null or empty");
        Mockito.when(service.searchPlaces(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();
        service.searchPlaces("type", "1.0", "2.0");
    }
    @Test
    public void testInvalidApiKey() throws IOException, URISyntaxException {
        expectedEx.expect(InvalidConfigurationException.class);
        expectedEx.expectMessage("ApiKey in configuration file is null or empty");
        Mockito.when(service.getUrl()).thenReturn("url");
        Mockito.when(service.getApiKey()).thenReturn(null);
        Mockito.when(service.searchPlaces(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();
        service.searchPlaces("type", "1.0", "2.0");
    }
    @Test
    public void testSearchPlaces() throws IOException, URISyntaxException {
        expectedEx.expect(ResourceAccessException.class);
        expectedEx.expectMessage("I/O error on GET request for \"http://localhost:1234/search?1.0&2.0&type&key\": Connection refused");
        Mockito.when(service.getUrl()).thenReturn("http://localhost:1234/search?{0}&{1}&{2}&{3}");
        Mockito.when(service.getApiKey()).thenReturn("key");
        Mockito.when(service.searchPlaces(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();
        service.searchPlaces("type", "1.0", "2.0");
    }
}
