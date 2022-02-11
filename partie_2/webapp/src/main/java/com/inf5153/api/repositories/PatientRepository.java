package com.inf5153.api.repositories;

import com.inf5153.api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT u FROM Patient u WHERE u.medicalCard = ?1")
    Patient findbyMedicalCard(String name);
    
}
