package com.example.springauthenticateendpoint;

import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
// this file is created by kushal
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication

public class SpringAuthenticateEndpointApplication {


	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		ClientHttpRequestFactory requestFactory = new
				HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
		return new RestTemplate(requestFactory);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringAuthenticateEndpointApplication.class, args);
	}	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*").allowCredentials(true);
			}
		};
	}
	

}

