package com.uppi.resource.poc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class WeatherMapController {
	@Value("${openweather.rest.endpoint}")
	private String weatherEndpoint;
	private RestTemplate restTemplate = new RestTemplate();
	@GetMapping("/weatherClient")
	public String getWeatherByZip(@RequestParam("zip")String zip,@RequestParam("country") String country) {
		Map<String,String> urlParams = new HashMap<>();
		urlParams.put("zip", zip+","+country);
		return restTemplate.exchange(weatherEndpoint, HttpMethod.GET, null, String.class,urlParams).getBody();
		
	}
}
