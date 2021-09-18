package com.example.springauthenticateendpoint.service;

import com.example.springauthenticateendpoint.model.Appointment;
import com.example.springauthenticateendpoint.model.Availability;
import com.example.springauthenticateendpoint.model.GenericResponse;

import com.example.springauthenticateendpoint.model.Physician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private RestTemplate restTemplate;
    final String BASE_URL = "http://daily-appointment-service/appointment/";
    private String allAppointmentUrl = BASE_URL + "get-appointment-all";
    private String setAppointmentUrl = BASE_URL + "set-appointment";
    private String appointmentByPhysician = BASE_URL + "get-appointment";

    public GenericResponse getResponse(){
        GenericResponse response = restTemplate.getForObject(allAppointmentUrl, GenericResponse.class);
        response.setMessage("added load balanced");
        return response;
    }
    public GenericResponse addPhysician(Physician physician) 
    {
    	System.out.println("Phy Id "+physician.getPhysicainId());
    	 return restTemplate.postForObject(BASE_URL + "add-physician/"+physician.getPhysicainId(), physician,GenericResponse.class);
    }
    public GenericResponse setAppointment(Appointment appointment){
        return restTemplate.postForObject(setAppointmentUrl,appointment, GenericResponse.class);
    }
    public GenericResponse getAppointmentByPhysicianId(String physicianId){
        return restTemplate.getForObject(appointmentByPhysician + "/" + physicianId, GenericResponse.class);
    }
    public GenericResponse getAllAppointment(){
        return restTemplate.getForObject(allAppointmentUrl, GenericResponse.class);
    }

    public ResponseEntity<List<Availability>> getAvailabilityByPhysicianIdAndDate(String physicianId, Date date){
        return restTemplate.getForObject(BASE_URL + "get-slots" + physicianId + date.toString(), ResponseEntity.class);
    }

    public ResponseEntity<List<Physician>> getPhysiciansBySpeciality(String speciality) {
        return restTemplate.getForObject(BASE_URL + "get-physicians" + speciality, ResponseEntity.class);
    }

    public GenericResponse deleteAppointmentById(String appointmentId){
        return restTemplate.getForObject(BASE_URL + "delete-appointment/" + appointmentId, GenericResponse.class);
    }

    public GenericResponse deleteAvailability(String availabilityId){
        return restTemplate.getForObject(BASE_URL + "delete-availability/" + availabilityId, GenericResponse.class);
    }
}
