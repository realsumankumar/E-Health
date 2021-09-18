package com.example.springauthenticateendpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springauthenticateendpoint.model.GenericResponse;

@Service
public class HospitalService {

	 @Autowired
	    private RestTemplate restTemplate;
	    final String BASE_URL = "http://hospital-admin-service/test/";

	    public GenericResponse getTestByName(String name){
	    	System.out.println(name+"............/..............///././././.././");
	        return restTemplate.getForObject(BASE_URL + "get-price-by-name/" + name, GenericResponse.class);
	    }
}
