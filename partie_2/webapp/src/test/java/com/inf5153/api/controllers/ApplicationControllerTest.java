package com.inf5153.api.controllers;

import com.inf5153.api.models.Document;
import com.inf5153.api.repositories.AntecedantRepository;
import com.inf5153.api.repositories.DocumentRepository;
import com.inf5153.api.repositories.VisitRepository;
import com.inf5153.api.services.AntecedantService;
import com.inf5153.api.services.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
class ApplicationControllerTest {

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
    @Test
    void redirectAfterLogin() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(redirectedUrl("/documents"));

    }

    @Test
    void redirectToLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(view().name("views/login"));
    }
}