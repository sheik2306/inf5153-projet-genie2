package com.inf5153.api.controllers;

import com.inf5153.api.models.Address;
import com.inf5153.api.models.Antecedant;
import com.inf5153.api.models.Document;
import com.inf5153.api.models.Visit;
import com.inf5153.api.repositories.AntecedantRepository;
import com.inf5153.api.repositories.DocumentRepository;
import com.inf5153.api.repositories.VisitRepository;
import com.inf5153.api.services.AntecedantService;
import com.inf5153.api.services.DocumentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
class DocumentControllerTest {


    @Autowired
    protected WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    Document document;

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    DocumentService documentService;

    @Autowired
    AntecedantService antecedantService;

    @Autowired
    AntecedantRepository antecedantRepository;
    @Autowired
    VisitRepository visitRepository;

    @BeforeEach
    public void setup() {
        mockMvc = webAppContextSetup(webAppContext).build();

    }

    @AfterEach
    public void down() {

    }

    @Test
    void documentList() throws Exception {
        ServletContext servletContext = webAppContext.getServletContext();

        Assertions.assertNotNull(servletContext);

        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webAppContext.getBean("documentController"));
        this.mockMvc.perform(get("/documents"))
                .andDo(print())
                .andExpect(view().name("views/documentList"));
    }

    @Test
    void documents() throws Exception {
        Document doc = documentRepository.findbyMedicalCard("doe1445");

        this.mockMvc.perform(get("/documents/{id}",doc.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/document"));
    }

    @Test
    void visit() throws Exception {
        Visit visit = visitRepository.findByDoctor("Dr.Test");
        this.mockMvc.perform(get("/documents/visits/{id}",visit.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/visits"));
    }

    @Test
    void antecedant() throws Exception {

        Antecedant antecedant = antecedantRepository.findByDoctor("Dr.Test");
        this.mockMvc.perform(get("/documents/antecedants/{id}",antecedant.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/antecedants"));

    }

    @Test
    void visitForm() throws Exception {

        Document document = documentRepository.findbyMedicalCard("doe1445");

        this.mockMvc.perform(get("/documents/visits/{id}/add",document.getId()))
                .andDo(print())
                .andExpect(status().isFound());
//                .andExpect(view().name("views/antecedants"));

        List<Visit> visits = visitRepository.findAll();
        Visit visit = visits.get(visits.size()-1);
        visitRepository.delete(visit);
    }

    @Test
    void visitSave() throws Exception {
        Visit visit = visitRepository.findByDoctor("Dr.Test");
        this.mockMvc.perform(get("/documents/visits/{id}/edit",visit.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/visitForm"));

    }

    @Test
    void antecedantForm() throws Exception {

        Antecedant antecedant = antecedantRepository.findByDoctor("Dr.Test");
        this.mockMvc.perform(get("/documents/antecedants/{id}/",antecedant.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void antecedantSave() throws Exception {
        Antecedant antecedant = antecedantRepository.findByDoctor("Dr.Test");
        this.mockMvc.perform(get("/documents/antecedants/{id}/edit",antecedant.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/antecedantForm"));
    }
}