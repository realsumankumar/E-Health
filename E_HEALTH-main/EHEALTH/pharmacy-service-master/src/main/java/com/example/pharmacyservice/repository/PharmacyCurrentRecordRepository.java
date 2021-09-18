package com.example.pharmacyservice.repository;

import com.example.pharmacyservice.model.PharmacyCurrentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyCurrentRecordRepository extends JpaRepository<PharmacyCurrentRecord, String> {

}
