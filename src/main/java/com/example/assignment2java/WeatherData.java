package com.example.assignment2java;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("temp")
   private double temp;

    // Getter for temp
   public double getTemp() {
        return temp;
  }


}
