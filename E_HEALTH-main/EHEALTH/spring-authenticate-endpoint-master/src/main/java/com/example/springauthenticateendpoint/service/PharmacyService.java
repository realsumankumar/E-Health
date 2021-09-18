package com.example.springauthenticateendpoint.service;

import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.PharmacyCurrentRecord;
import com.example.springauthenticateendpoint.model.PharmacyHistory;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.GeneratedValue;

@Service
public class PharmacyService {

    @Autowired
    private RestTemplate restTemplate;
    private final String HISTORY_BASE_URL = "http://pharmacy-service/history/pharmacy/";
    private final String CURRENT_BASE_URL = "http://pharmacy-service/pharmacy/";
    private final String MEDICINE_URL = "http://pharmacy-service/med/";

    public GenericResponse getAllRecords(){
        return restTemplate.getForObject(CURRENT_BASE_URL + "get-all-records", GenericResponse.class);
    }

    public GenericResponse deleteActiveRecordById(String id){
        return restTemplate.getForObject(CURRENT_BASE_URL + "delete-by-id/" + id, GenericResponse.class);
    }

    public GenericResponse addRecord(PharmacyCurrentRecord record){
        return restTemplate.postForObject(CURRENT_BASE_URL + "add-record" , record, GenericResponse.class);
    }

    public GenericResponse getAllHistory(){
        return restTemplate.getForObject(HISTORY_BASE_URL + "get-all-history", GenericResponse.class);
    }

    public GenericResponse insertHistory(PharmacyHistory history){
        return restTemplate.postForObject(HISTORY_BASE_URL + "insert-history", history, GenericResponse.class);
    }

    public GenericResponse getMedicineByName(String medName){
        return restTemplate.getForObject(MEDICINE_URL  + "get-medicine-by-name/" + medName, GenericResponse.class);
    }
    public GenericResponse getPharmacyById(String id){
        return restTemplate.getForObject(CURRENT_BASE_URL  + "get-pharmacy-by-id/" + id, GenericResponse.class);
    }
}
