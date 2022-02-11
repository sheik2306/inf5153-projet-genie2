package com.inf5153.api.controllers;

import com.inf5153.api.models.Address;
import com.inf5153.api.models.Contact;
import com.inf5153.api.models.Gender;
import com.inf5153.api.models.Patient;
import com.inf5153.api.repositories.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
class PatientControllerTest {

    Patient patient;

    @Autowired
    PatientRepository repository;

    @BeforeEach
    public void setup() {
//        Address add = new Address("250","test");
//        String[] parents = {"Marise Test", "Maurice Test"};
//        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
//        patient = new Patient("Guy", "dmoa", Gender.Male, parents, "Montreal", contact , "okbuddy12");
//
//        repository.save(patient);
    }

    @AfterEach
    public void down() {
//        repository.delete(patient);
    }


    @Test
    void getAllPatients() {
        List<Patient> patients =repository.findAll();
        Assertions.assertEquals(3,patients.size());
    }

    @Test
    void edit() {
        Patient patient = repository.findbyMedicalCard("doe1445");

        Assertions.assertEquals("doe1445",patient.getMedicalCard());
    }
}