package com.inf5153.api.repositories;

import com.inf5153.api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, Integer> {


    @Query("SELECT u FROM Document u WHERE u.patient.medicalCard = ?1")
    Document findbyMedicalCard(String name);
}
