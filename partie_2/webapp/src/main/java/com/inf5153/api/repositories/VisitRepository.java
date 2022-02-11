package com.inf5153.api.repositories;

import com.inf5153.api.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inf5153.api.models.Visit;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    @Query("SELECT u FROM Visit u WHERE u.doctor = ?1")
    Visit findByDoctor(String name);
}