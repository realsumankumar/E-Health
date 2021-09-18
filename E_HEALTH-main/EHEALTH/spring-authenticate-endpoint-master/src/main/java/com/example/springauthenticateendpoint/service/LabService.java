package com.example.springauthenticateendpoint.service;


import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.LabRecord;
import com.example.springauthenticateendpoint.model.LabRecordPast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LabService {
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://laboratory-service/laboratory/";

    public GenericResponse getAllLabRecords(){
        return restTemplate.getForObject(BASE_URL + "get-labrecords-all", GenericResponse.class);
    }

    public GenericResponse addLabRecord(LabRecord labRecord){
        return restTemplate.postForObject(BASE_URL + "add-lab-record", labRecord, GenericResponse.class);
    }

    public GenericResponse getAllLabHistory(){
        return restTemplate.getForObject(BASE_URL + "get-labrecords-all-past", GenericResponse.class);
    }

    public GenericResponse addLabHistory(LabRecordPast labRecordPast){
        return restTemplate.postForObject(BASE_URL + "add-past-testrecord/" + labRecordPast.getTestId(), labRecordPast, GenericResponse.class);
    }
    
    
    public GenericResponse getLabTestByTreatmentId(String id) 
    {
    	return restTemplate.getForObject(BASE_URL + "/get-labtests-past/" + id , GenericResponse.class);
    }

//    public GenericResponse uploadImage(MultipartFile multipartFile){
//        return
//            restTemplate.postForObject(BASE_URL + "image/upload",
//                    multipartFile,
//                    GenericResponse.class);
//    }
//
//    public GenericResponse retrieveImage(String labTestId){
//        return restTemplate.getForObject(BASE_URL + "image/get/" + labTestId, GenericResponse.class);
//    }
}
