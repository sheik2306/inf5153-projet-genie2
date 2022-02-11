package com.inf5153.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inf5153.api.models.Address;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT u FROM Address u WHERE u.civicNumber = ?1")
    Address findAddressByCivicNumber(String name);

    
}