package com.google.maps.ws.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.ws.controller.GoogleMapsApiController;
import com.google.maps.ws.model.Place;
import com.google.maps.ws.model.PlaceResponse;
import com.google.maps.ws.service.GoogleMapsApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class GoogleMapsApiControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GoogleMapsApiService googleMapsApiService;

    @InjectMocks
    private GoogleMapsApiController  controller;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testSearchPlaces() throws Exception {
        Place first = new Place();
        first.setName("Place 1");
        PlaceResponse response = new PlaceResponse();
        response.setResults(Arrays.asList(first));
        response.setStatus("OK");

        RequestBuilder builder = MockMvcRequestBuilders.get("/searchPlaces")
                .param("latitude", "45.5")
                .param("longitude", "30.1")
                .contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(response));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
        verify(googleMapsApiService, times(1)).searchPlaces(anyString(), anyString());
        verifyNoMoreInteractions(googleMapsApiService);
    }

    @Test
    public void testSearchPlacesInvalidLatitude() throws Exception {
        Place first = new Place();
        first.setName("Place 1");
        PlaceResponse response = new PlaceResponse();
        response.setResults(Arrays.asList(first));
        response.setStatus("OK");

        RequestBuilder builder = MockMvcRequestBuilders.get("/searchPlaces")
                .param("latitude", "A")
                .param("longitude", "1")
                .contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(response));

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()));
        verifyZeroInteractions(googleMapsApiService);
    }

    private static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }
}
