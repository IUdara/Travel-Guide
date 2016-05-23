package com.travelsoft.lanka.travel_guide.network;

import com.travelsoft.lanka.travel_guide.models.PlaceCategory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Isuru on 2016-03-19.
 */
public class APIGateWay {
    public static JSONObject callApiForJsonObject(final String apiUrl) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        JSONObject apiResponseJson = null;
        try {
            URL data_url = new URL(apiUrl);
            urlConnection = (HttpURLConnection) data_url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0) {
                return null;
            }
            String apiResponseJsonStr = buffer.toString();
            apiResponseJson = new JSONObject(apiResponseJsonStr);
        } catch (IOException | JSONException e) {
            System.out.println("Error loading images : " + e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    System.out.println("Error closing stream :" + e);
                }
            }
        }
        return apiResponseJson;
    }
}
