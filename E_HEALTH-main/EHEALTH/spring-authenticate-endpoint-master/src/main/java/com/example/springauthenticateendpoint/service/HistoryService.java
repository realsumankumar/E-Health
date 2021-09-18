package com.example.springauthenticateendpoint.service;

import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.TreatmentHistory;

import net.bytebuddy.description.type.TypeDescription.Generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class HistoryService {
    @Autowired
    private RestTemplate restTemplate;
    final String BASE_URL = "http://treatment-history-service/history/";

    public GenericResponse getAllRecordsByPatientId(String patientId){
        return restTemplate.getForObject(BASE_URL + "patient/" + patientId, GenericResponse.class);
    }

    public GenericResponse getAllRecordsByPhysicianId(String physicianId){
        return restTemplate.getForObject(BASE_URL + "physician/" + physicianId, GenericResponse.class);
    }


    public GenericResponse insertHistory(TreatmentHistory history){
        return restTemplate.postForObject(BASE_URL + "insert-history", history, GenericResponse.class);
    }

    public GenericResponse updateRecord(TreatmentHistory record){
        GenericResponse response = restTemplate.postForObject(BASE_URL + "update-history",
                record, GenericResponse.class);
        return (response != null) ? response : new GenericResponse(0, "some error occurred", null);
    }

    public GenericResponse getSingleRecordById(String recordId){
        return restTemplate.getForObject(BASE_URL + "get-history-by-id/" + recordId, GenericResponse.class);
    }
    
    //hospital-admin
    public GenericResponse getAllRecord() {
    	return restTemplate.getForObject(BASE_URL + "get-all-records-to-be-paid", GenericResponse.class);
    }
    public GenericResponse updatePayment(String id) {
    	return restTemplate.getForObject(BASE_URL + "update-payment/" + id, GenericResponse.class);
    }
}
