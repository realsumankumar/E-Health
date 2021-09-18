package com.example.pharmacyservice.repository;

import com.example.pharmacyservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
}
