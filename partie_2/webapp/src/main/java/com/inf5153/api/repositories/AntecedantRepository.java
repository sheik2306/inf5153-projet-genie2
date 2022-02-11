package com.inf5153.api.repositories;

import com.inf5153.api.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inf5153.api.models.Antecedant;
import org.springframework.data.jpa.repository.Query;

public interface AntecedantRepository extends JpaRepository<Antecedant, Integer> {
    @Query("SELECT u FROM Antecedant u WHERE u.doctor = ?1")
    Antecedant findByDoctor(String name);
}