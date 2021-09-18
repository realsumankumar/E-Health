package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TestDetails;

public interface TestRepository extends JpaRepository<TestDetails, String> {
	
	TestDetails findByTestname(String name);
}	
