package com.example.assignment2java;

import com.google.gson.annotations.SerializedName;
import java.util.List;

// Class representing the overall response from the OpenWeatherMap API
public class WeatherResponse {

    // The 'main' field is mapped to the "main" field in the JSON response
    @SerializedName("main")
    private WeatherData main;

    // The 'weather' field is mapped to the "weather" field in the JSON response, which is a list
    @SerializedName("weather")
    private List<Weather> weather;

    // Getter and Setter for 'main'
    public WeatherData getMain() {
        return main;
    }

    public void setMain(WeatherData main) {
        this.main = main;
    }

    // Getter and Setter for 'weather'
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
