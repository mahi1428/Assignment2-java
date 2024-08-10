package com.example.assignment2java;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Utility class for interacting with the OpenWeatherMap API.
 * Provides methods to fetch weather data for a given city.
 */
public class APIUtility {

    /** OpenWeatherMap API key. */
    private static final String API_KEY = "9b1227b89b476123ad5bc87ebb1bd659";

    /** Base URL for the OpenWeatherMap API. */
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    /**
     * Fetches weather data for a given city name.
     *
     * @param cityName The name of the city for which to fetch weather data.
     * @return A {@link WeatherResponse} object containing the weather data for the specified city,
     *         or {@code null} if an error occurs while fetching the data.
     */
    public static WeatherResponse getWeather(String cityName) {
        // Construct the full API request URL with the city name, API key, and units set to metric
        String url = BASE_URL + "?q=" + cityName + "&appid=" + API_KEY + "&units=metric";

        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest object with the constructed URL
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            // Send the request and get the response as a string
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Create a Gson instance for JSON processing
            Gson gson = new Gson();

            // Convert the JSON response into a WeatherResponse object and return it
            return gson.fromJson(response.body(), WeatherResponse.class);
        } catch (Exception e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }

        return null;
    }
}
