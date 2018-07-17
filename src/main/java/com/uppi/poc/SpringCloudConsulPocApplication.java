package com.uppi.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.uppi.resource.poc.DiscoveryClientController;
import com.uppi.resource.poc.WeatherMapController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses= {DiscoveryClientController.class,WeatherMapController.class})
public class SpringCloudConsulPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulPocApplication.class, args);
	}
}
