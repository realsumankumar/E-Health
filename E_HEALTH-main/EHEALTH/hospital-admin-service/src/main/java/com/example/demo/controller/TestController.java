package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.TestRepository;
import com.example.demo.model.GenericResponse;
import com.example.demo.model.TestDetails;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestRepository testRepo;
	
	@RequestMapping(value="/get-price-by-name/{name}")
	public GenericResponse getPrice(@PathVariable String name) 
	{
		return new GenericResponse(1,"success",testRepo.findByTestname(name));
	}
	
	
	@PostMapping("/add-test")
	public GenericResponse addTest(@RequestBody TestDetails test)
	{
		testRepo.save(test);
		return new GenericResponse(1,"succes",null);
	}
	
	
}
