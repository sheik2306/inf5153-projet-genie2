package com.inf5153.api.controllers;
import java.time.LocalDate;

import javax.validation.constraints.Null;

import com.inf5153.api.models.Antecedant;
import com.inf5153.api.models.Document;
import com.inf5153.api.models.DocumentHistory;
import com.inf5153.api.models.Institution;
import com.inf5153.api.models.Visit;
import com.inf5153.api.services.AntecedantService;
import com.inf5153.api.services.DocumentHistoryService;
import com.inf5153.api.services.DocumentService;
import com.inf5153.api.services.VisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value ="/api")
public class DocumentHistoryController {

    @Autowired
    DocumentService documentService;

    @Autowired
    AntecedantService antecedantService;

    @Autowired
    VisitService visitService;
    
    @Autowired
    DocumentHistoryService documentHistoryService;


    @PostMapping(value="/visits/{id}/save") 
    @ResponseStatus(HttpStatus.CREATED)   
    public ResponseEntity <String> saveVisit(@RequestBody Visit visitDetails, @PathVariable int id){

        Visit visit = visitService.fetchOneById(id);
        visit.setInstitution(visitDetails.getInstitution());
        visit.setDoctor(visitDetails.getDoctor());
        visit.setVisitDate(visitDetails.getVisitDate());
        visit.setDiagnostic(visitDetails.getDiagnostic());
        visit.setTreatment(visitDetails.getTreatment());
        visit.setSummary(visitDetails.getSummary());
        visit.setNotes(visitDetails.getNotes());
        Document document = visit.getDocument();
        DocumentHistory documentHistory = new DocumentHistory(document);

        visitService.createOrSave(visit);
        documentHistoryService.createOrSave(documentHistory);
        return ResponseEntity.ok("saved");
    }   

    @PostMapping(value="/visits/{id}/cancel") 
    @ResponseStatus(HttpStatus.CREATED)   
    public ResponseEntity <String> cancelVisit(@RequestBody Visit visitDetails, @PathVariable int id){

        if(visitDetails.getInstitution() == Institution.NONE && visitDetails.getDoctor() == ""  && visitDetails.getDiagnostic() == "" && visitDetails.getTreatment() == "" && visitDetails.getSummary() == "" && visitDetails.getNotes() == "" ){
            visitService.delete(id);
            return ResponseEntity.ok("Deleted");
        }
        Visit visit = visitService.fetchOneById(id);
        visit.setInstitution(visitDetails.getInstitution());
        visit.setDoctor(visitDetails.getDoctor());
        visit.setVisitDate(visitDetails.getVisitDate());
        visit.setDiagnostic(visitDetails.getDiagnostic());
        visit.setTreatment(visitDetails.getTreatment());
        visit.setSummary(visitDetails.getSummary());
        visit.setNotes(visitDetails.getNotes());
        Document document = visit.getDocument();
        DocumentHistory documentHistory = new DocumentHistory(document);

        visitService.createOrSave(visit);
        documentHistoryService.createOrSave(documentHistory);
        return ResponseEntity.ok("saved");
    }   

    @PostMapping(value="/antecedants/{id}/save")  
    public ResponseEntity <String> saveAntecedants(@RequestBody Antecedant antecedantDetails, @PathVariable int id){

        Antecedant antecedant = antecedantService.fetchOneById(id);
        antecedant.setDiagnostic(antecedantDetails.getDiagnostic());
        antecedant.setTreatment(antecedantDetails.getTreatment());
        antecedant.setDoctor(antecedantDetails.getDoctor());

        antecedant.setSicknessStart(antecedantDetails.getSicknessStart());
        antecedant.setSicknessEnd(antecedantDetails.getSicknessEnd());
        Document document = antecedant.getDocument();
        DocumentHistory documentHistory = new DocumentHistory(document);

        antecedantService.createOrSave(antecedant);
        documentHistoryService.createOrSave(documentHistory);
        return ResponseEntity.ok("saved");
    
    }

    @PostMapping(value="/antecedants/{id}/cancel")  
    public ResponseEntity <String> CancelAntecedants(@RequestBody Antecedant antecedantDetails, @PathVariable int id){


        if(antecedantDetails.getDiagnostic() == "" && antecedantDetails.getTreatment() == ""  && antecedantDetails.getDoctor() == "" && antecedantDetails.getTreatment() == ""){
            antecedantService.delete(id);
            return ResponseEntity.ok("Deleted");
        }

        Antecedant antecedant = antecedantService.fetchOneById(id);
        antecedant.setDiagnostic(antecedantDetails.getDiagnostic());
        antecedant.setTreatment(antecedantDetails.getTreatment());
        antecedant.setDoctor(antecedantDetails.getDoctor());

        antecedant.setSicknessStart(antecedantDetails.getSicknessStart());
        antecedant.setSicknessEnd(antecedantDetails.getSicknessEnd());
        Document document = antecedant.getDocument();
        DocumentHistory documentHistory = new DocumentHistory(document);

        antecedantService.createOrSave(antecedant);
        documentHistoryService.createOrSave(documentHistory);
        return ResponseEntity.ok("saved");
    
    }


    
}

