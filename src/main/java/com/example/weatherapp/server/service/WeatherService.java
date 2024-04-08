package com.example.weatherapp.server.service;

public interface WeatherService {

     public Object forecastSummaryByLocationName(String location);

     public Object hourlyForecastByLocationName(long lon, long lat);

}
