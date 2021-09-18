package com.example.emailservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailservice.dto.MailRequest;
import com.example.emailservice.dto.MailResponse;
import com.example.emailservice.service.EmailService;

@CrossOrigin("*")
@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	
	@PostMapping("/send/Email")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		
		System.out.println(request.getPatientName() + " " + request.getPatientEmail() + " " + request.getPhysicianName());
		Map<String, Object> model = new HashMap<>();
		model.put("patientName", request.getPatientName());
		model.put("physicianName", request.getPhysicianName());
		model.put("appointmentId", request.getAppointmentId());
		model.put("date", request.getDate());
		model.put("time", request.getTime());
		
		request.setFrom("gautambhatiani.1999@gmail.com");
		request.setSubject("Appointment is Confirmed");
		return service.sendEmail(request, model);
		
		
	}
}
