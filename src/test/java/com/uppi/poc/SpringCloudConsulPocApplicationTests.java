package com.uppi.poc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudConsulPocApplicationTests {
	@Value("${openweather.rest.endpoint}")
	private String weatherEndpoint;
	@Test
	public void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(weatherEndpoint);
		Map<String,String> urlParams = new HashMap<>();
		urlParams.put("zip", "500616"+",in");
		System.out.println(restTemplate.exchange(weatherEndpoint, HttpMethod.GET, null, String.class,urlParams).getBody());
	}

}
