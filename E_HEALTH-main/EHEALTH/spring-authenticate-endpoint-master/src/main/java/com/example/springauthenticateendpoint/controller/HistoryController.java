package com.example.springauthenticateendpoint.controller;

import com.example.springauthenticateendpoint.model.GenericResponse;
import com.example.springauthenticateendpoint.model.LabRecord;
import com.example.springauthenticateendpoint.model.PharmacyCurrentRecord;
import com.example.springauthenticateendpoint.model.TreatmentHistory;
import com.example.springauthenticateendpoint.service.HistoryService;

import com.example.springauthenticateendpoint.service.LabService;
import com.example.springauthenticateendpoint.service.PharmacyService;
import com.example.springauthenticateendpoint.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired

    private PharmacyService pharmacyService;

    @Autowired
    private LabService labService;
    
    @Autowired
    private HospitalService hospitalService;
    


    @RequestMapping("/get-all-records-by-patient-id/{patientId}")
    public GenericResponse getAllRecordsByPatientId(@PathVariable String patientId){
        return historyService.getAllRecordsByPatientId(patientId);
    }

    @RequestMapping("/get-all-records-by-physician-id/{physicianId}")
    public GenericResponse getAllRecordsByPhysicianId(@PathVariable String physicianId){
        return historyService.getAllRecordsByPhysicianId(physicianId);
    }
    @RequestMapping(value = "/insert-history", method = RequestMethod.POST)
    public GenericResponse insertHistory(@RequestBody TreatmentHistory history){
        return historyService.insertHistory(history);
    }

    @RequestMapping(value = "/update-record", method = RequestMethod.POST)
    public GenericResponse updateRecord(@RequestBody TreatmentHistory record){
        GenericResponse response = historyService.updateRecord(record);
        return (response != null) ? response : new GenericResponse(0, "some error occurred", null);
    }

    @RequestMapping("/get-history-by-id/{recordId}")
    public GenericResponse getRecordById(@PathVariable String recordId){
        return historyService.getSingleRecordById(recordId);
    }

//    @RequestMapping(value = "/magical-request")
//    public GenericResponse postMagicalRequest(TreatmentHistory treatmentHistory){
////        historyService.insertHistory(treatmentHistory);
////        PharmacyCurrentRecord pharmacyCurrentRecord =
////                new PharmacyCurrentRecord(treatmentHistory.getTreatmentId(),
////                        treatmentHistory.getPatientId(),
////                        treatmentHistory.getPhysicianId(),
////                        treatmentHistory.getPrescription(),
////                        treatmentHistory.getMedicines(),
////                        treatmentHistory.getDate(),
////                        treatmentHistory.getTime());
////        pharmacyService.addRecord(pharmacyCurrentRecord);
////        String[] tests = treatmentHistory.getTest().split(",");
////        for (String test : tests) {
////            LabRecord labRecord =
////                    new LabRecord(treatmentHistory.getTreatmentId(),
////                            test,
////                            treatmentHistory.getPhysicianId(),
////                            treatmentHistory.getPatientId(),
////                            treatmentHistory.getDate(),
////                            treatmentHistory.getTime());
////            labService.addLabRecord(labRecord);
////        }
////        labService.addLabRecord(new LabRecord(
////                "treatment-id",
////                "test-name",
////                "physician-id",
////                "patient-id",
////                new Date(10, 10, 10),
////                new Time(10, 10, 10)));
//        return new GenericResponse(1, "success", labService.addLabRecord(new LabRecord(
//                "treatment-id",
//                "test-name",
//                "physician-id",
//                "patient-id",
//                new Date(10, 10, 10),
//                new Time(10, 10, 10))));
//    }

    
    //hospital - admin
    @RequestMapping("/get-all-records-to-be-paid")
    public GenericResponse getRecords() 
    {
    	System.out.println("Callrd get all records.......................................................................................");
    	return historyService.getAllRecord();
    }
    
    @RequestMapping("get-test-by-name/{name}")
    public GenericResponse getTestByName(@PathVariable String name)
    {
    	System.out.println(name+"......................................................//////////////");
    	return hospitalService.getTestByName(name);
    }
    
    @RequestMapping("/update-payment/{id}")
    public GenericResponse updatedPayment(@PathVariable String id)
    {
    	return historyService.updatePayment(id);
    }
}
