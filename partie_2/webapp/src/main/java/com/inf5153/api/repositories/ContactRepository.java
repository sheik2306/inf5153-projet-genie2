package com.inf5153.api.repositories;

import com.inf5153.api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
