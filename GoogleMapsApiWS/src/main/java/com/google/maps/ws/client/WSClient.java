package com.google.maps.ws.client;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by X on 31/05/2016.
 */
public class WSClient {
//    public static void main(String[] args) {
//        try {
//            String urlString = "http://localhost:8080/searchPlaces?location=43.768353,-79.41304630000002&type=restaurant";
//            if (args != null && args.length > 0) {
//                urlString = args[0];
//            }
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            StringBuilder sb = new StringBuilder();
//            while ((output = br.readLine()) != null) {
//                sb.append(output);
//                sb.append(System.getProperty("line.separator"));
//            }
//
//            conn.disconnect();
//
//            JSONObject json = new JSONObject(sb.toString()); // Convert text to object
//            System.out.println(json.toString(4)); // Print it with specified indentation
//
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//    }
}
