package com.example.weatherapp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weatherapp.rapidApi.summary.Key}")
    private String rapidApiKey;

    @Value("${weatherapp.rapidApi.Host}")
    private String rapidApiHost;

    @Value("${weatherapp.rapidApi.url}")
    private String rapidApiSummaryUrl;

    @Value("${openweathermap.api.url}")
    private String openWeatherMapHourlyUrl;

    @Value(("${openweathermap.api.key}"))
    private String openWeatherMapHourlyApiKey;

    final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Object forecastSummaryByLocationName(String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);
        String url = String.format(rapidApiSummaryUrl, location);
        String responseBody = restTemplate.
                exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody();
        return responseBody;
    }

    @Override
    public Object hourlyForecastByLocationName(long lon, long lat) {
        String url = String.format("%s?lat=%d&lon=%d&appid=%s", openWeatherMapHourlyUrl, lon, lat, openWeatherMapHourlyApiKey);
        String body = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        return body;
    }
}
