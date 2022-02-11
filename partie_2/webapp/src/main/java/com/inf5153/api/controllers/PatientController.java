package com.inf5153.api.controllers;

import java.util.List;

import com.inf5153.api.models.Patient;
import com.inf5153.api.services.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api")
public class PatientController {

    @Autowired
    PatientService patientService;

    // http://localhost:8888/api/patients/
    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients() {
        return patientService.fetchAll();
    }

    @RequestMapping(value="/patients/{id}")    
    public Patient edit(@PathVariable int id){    
        return  patientService.fetchOneById(id);  
    }   
}
