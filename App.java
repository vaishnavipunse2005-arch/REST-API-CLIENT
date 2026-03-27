package com.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
        // Public API URL for London weather
        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=51.5074&longitude=-0.1278&current_weather=true";

        try {
            // 1. Establish the connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 2. Check if the request was successful
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                // 3. Read the data from the API
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 4. Send the raw string to our parser
                formatAndPrintData(response.toString());

            } else {
                System.out.println("Error: API returned HTTP " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void formatAndPrintData(String jsonString) {
        // Convert the raw string into a JSON Object
        JSONObject fullResponse = new JSONObject(jsonString);
        
        // Navigate to the "current_weather" section of the JSON
        JSONObject weather = fullResponse.getJSONObject("current_weather");

        // Extract specific values
        double temperature = weather.getDouble("temperature");
        double windspeed = weather.getDouble("windspeed");
        String time = weather.getString("time");

        // Display in a structured format
        System.out.println("====================================");
        System.out.println("   CURRENT WEATHER REPORT: INDIA   ");
        System.out.println("====================================");
        System.out.println("Date/Time:   " + time);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Wind Speed:  " + windspeed + " km/h");
        System.out.println("====================================");
    }
}