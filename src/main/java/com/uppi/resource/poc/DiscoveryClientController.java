package com.uppi.resource.poc;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class DiscoveryClientController {
	 @Autowired
	 private DiscoveryClient discoveryClient;
	 
	 private RestTemplate restTemplate=new RestTemplate() ;
	    public Optional<URI> serviceUrl() {
	        return discoveryClient.getInstances("spring-config-consul")
	          .stream()
	          .map(si->si.getUri())
	          .findFirst();
	    }
	    @GetMapping("/discoveryClient")
	    public String discoveryPing(@RequestParam("zip")String zip,@RequestParam("country") String country) throws ServiceUnavailableException {
	        String templateUrl = serviceUrl()
	          .map(s -> s.resolve("/weatherClient").toString()+"?zip={zip}&country={country}")
	          .orElseThrow(ServiceUnavailableException::new);
	        Map<String,String> urlParams = new HashMap<>();
			urlParams.put("zip", zip);
			urlParams.put("country", country);
			return restTemplate.exchange(templateUrl, HttpMethod.GET, null, String.class,urlParams).getBody();
	    }
	     
	    
}
