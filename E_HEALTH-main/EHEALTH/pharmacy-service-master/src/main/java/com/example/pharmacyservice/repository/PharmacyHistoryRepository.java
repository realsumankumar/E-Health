package com.example.pharmacyservice.repository;

import com.example.pharmacyservice.model.PharmacyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyHistoryRepository extends JpaRepository<PharmacyHistory, String> {
}
