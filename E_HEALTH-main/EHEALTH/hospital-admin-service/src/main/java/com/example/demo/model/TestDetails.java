package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TestDetails {

	@Id
	private String testname;
	private int testprice;
	
	public TestDetails() {}
	public TestDetails(String testname , int testprice) {
		this.testname = testname;
		this.testprice = testprice;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public int getTestprice() {
		return testprice;
	}
	public void setTestprice(int testprice) {
		this.testprice = testprice;
	}
	
	
}
