package com.example.pharmacyservice.controller;


import com.example.pharmacyservice.model.GenericResponse;
import com.example.pharmacyservice.model.PharmacyCurrentRecord;
import com.example.pharmacyservice.model.PharmacyHistory;
import com.example.pharmacyservice.repository.PharmacyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/history/pharmacy")
public class HistoryController {

    @Autowired
    private PharmacyHistoryRepository repository;

    @RequestMapping("/get-all-history")
    public GenericResponse getAllHistory(){
        return new GenericResponse(1, "success", repository.findAll());
    }

    @RequestMapping(value = "/insert-history", method = RequestMethod.POST)
    public GenericResponse insertHistory(@RequestBody PharmacyHistory history){
        return new GenericResponse(1, "success", repository.save(history));
    }

    @RequestMapping("/sample")
    public GenericResponse getSample(){
        PharmacyHistory history =
                new PharmacyHistory("id", "treatmentId", "patientid", "physicianid", "prescirption", "medicine", new Date(10, 10, 10), new Time(10 , 10 ,10));

        return new GenericResponse(1, "success", history);
    }
}
