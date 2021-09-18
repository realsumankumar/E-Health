package com.example.pharmacyservice.controller;

import com.example.pharmacyservice.model.GenericResponse;
import com.example.pharmacyservice.model.Medicine;
import com.example.pharmacyservice.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/med")
public class MedicineController {

    @Autowired
    private MedicineRepository repository;

    @RequestMapping("get-medicine-by-name/{medName}")
    public GenericResponse getMedicinePriceByName(@PathVariable String medName){
        if(repository.findById(medName).isPresent()){
            Medicine medicine = repository.findById(medName).get();
            return new GenericResponse(1, "success", medicine);
        }else{
            return new GenericResponse(0, "medicine is not available", null);
        }
    }
    @RequestMapping(value = "add-medicine", method = RequestMethod.POST)
    public GenericResponse addMedicine(@RequestBody Medicine medicine){
        return new GenericResponse(1,"success", repository.save(medicine));
    }

    @RequestMapping("sample")
    public GenericResponse getSample(){
        Medicine medicine = new Medicine("PCM", 2, "100");
        return new GenericResponse(1, "success", medicine);
    }
}
