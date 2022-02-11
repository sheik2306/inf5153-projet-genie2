package com.inf5153.api.controllers;

import java.time.LocalDate;
import java.util.List;
import com.inf5153.api.models.*;
import com.inf5153.api.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(value = "/documents")
public class DocumentController {

    @Autowired
    DocumentService documentService;
    @Autowired
    VisitService visitService;
    @Autowired
    AntecedantService antecedantService;
    @Autowired
    PatientService patientService;

    @Autowired
    DocumentHistoryService documentHistoryService;


    @GetMapping("")
    public ModelAndView documentList() {
        List<Document> documents = documentService.fetchAll();
        ModelAndView mav = new ModelAndView("views/documentList");
        mav.addObject("documents", documents);
        mav.addObject("date",LocalDate.now());
        return mav;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView documents(@PathVariable int id) {
        Document document = documentService.fetchOneById(id);
        ModelAndView mav = new ModelAndView("views/document");
        mav.addObject("document", document);
        return mav;
    }

    @RequestMapping(value = "/visits/{id}")
    public ModelAndView visit(@PathVariable int id, Model m) {
        Visit visit = visitService.fetchOneById(id);
        m.addAttribute("visit", visit);
        ModelAndView mav = new ModelAndView("views/visits");
        mav.addObject("visit", visit);
        return mav;
    }

    @RequestMapping(value = "/antecedants/{id}")
    public ModelAndView antecedant(@PathVariable int id, Model m) {
        Antecedant antecedant = antecedantService.fetchOneById(id);
        m.addAttribute("antecedant", antecedant);
        ModelAndView mav = new ModelAndView("views/antecedants");
        mav.addObject("antecedant", antecedant);
        return mav;
    }

    @RequestMapping(value="/visits/{id}/add", method = RequestMethod.GET)
    public String visitForm(@PathVariable int id){
        Visit visit = new Visit();
        visit.setInstitution(Institution.NONE);
        visit.setVisitDate(LocalDate.now());
        Document document = documentService.fetchOneById(id);
        visit.setDocument(document);
        document.setVisits(visit);
        DocumentHistory documentHistory = new DocumentHistory(document);
        documentHistoryService.createOrSave(documentHistory);
        
        return "redirect:/documents/visits/" + visit.getId() +"/edit";
    }

    @RequestMapping(value="/visits/{id}/edit",method = RequestMethod.GET)
    public String visitSave(Model m , @PathVariable int id){
        Visit visit = visitService.fetchOneById(id);
        m.addAttribute("visit", visit);
        m.addAttribute("id", id);
        return "views/visitForm";
    }

    @RequestMapping(value="/antecedants/{id}/add", method = RequestMethod.GET)
    public String antecedantForm(@PathVariable int id){
        Antecedant antecedant = new Antecedant();
        antecedant.setSicknessStart(LocalDate.now());
        antecedant.setSicknessEnd(LocalDate.now());
        Document document = documentService.fetchOneById(id);
        antecedant.setDocument(document);
        document.setAntecedants(antecedant);
        DocumentHistory documentHistory = new DocumentHistory(document);
        documentHistoryService.createOrSave(documentHistory);
        return "redirect:/documents/antecedants/" + antecedant.getId() +"/edit";
    }

    @RequestMapping(value="/antecedants/{id}/edit",method = RequestMethod.GET)
    public String antecedantSave(Model m, @PathVariable int id){
        Antecedant antecedant = antecedantService.fetchOneById(id);
        m.addAttribute("antecedant", antecedant);
        m.addAttribute("id", id);
        return "views/antecedantForm";
    }
}