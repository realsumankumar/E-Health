package com.example.springauthenticateendpoint.controller;


import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.LabRecord;
import com.example.springauthenticateendpoint.model.LabRecordPast;
import com.example.springauthenticateendpoint.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lab")
public class LabServiceController {

    @Autowired
    private LabService service;

    @RequestMapping("/get-all-records")
    public GenericResponse getAllRecords(){
        return service.getAllLabRecords();
    }

    @RequestMapping(value = "/add-lab-records", method = RequestMethod.POST)
    public GenericResponse addLabRecord(@RequestBody LabRecord record){
        return service.addLabRecord(record);
    }

    @RequestMapping("/get-all-history")
    public GenericResponse getAllHistory(){
        return service.getAllLabHistory();
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add-history", method = RequestMethod.POST)
    public GenericResponse addHistory(@RequestBody LabRecordPast history){
        return service.addLabHistory(history);
    }
    
    @RequestMapping(value = "/get-lab-test-by-treatment-id/{id}")
    public GenericResponse getLabTestById(@PathVariable String id)
    {
    	return service.getLabTestByTreatmentId(id);
    }

//    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
//    public GenericResponse uploadImage(@RequestParam("file") MultipartFile file){
//        return service.uploadImage(file);
//    }
//
//    @RequestMapping(value = "image/get/{labTestId}")
//    public GenericResponse getImage(@PathVariable String labTestId){
//        return service.retrieveImage(labTestId);
//    }
//
//    @RequestMapping(value = "/sample", method = RequestMethod.POST)
//    public String testing(){
//        return "Hello World post request";
//    }
}
