package com.inf5153.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.inf5153.api.models.Address;
import com.inf5153.api.repositories.AddressRepository;
import com.inf5153.api.services.AddressService;
import io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.ServletContext;
import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
//@WebAppConfiguration
@SpringBootTest
class AddressControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    protected WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    @Autowired
    AddressRepository repository;


    private Address address;

    @Autowired
    private ObjectMapper objectMapper;


    private AddressService service;

    @BeforeEach
    public void setup() {
        mockMvc = webAppContextSetup(webAppContext).build();
        address = new Address("555","Dubois");
        repository.save(address);
    }

    @AfterEach
    public void down() {
        repository.delete(address);
    }

    @Test
    public void webAppContextTest() throws Exception {
        assertTrue(webAppContext.getServletContext() instanceof MockServletContext);
    }


    @Test
    void addresses() throws Exception {
        ServletContext servletContext = webAppContext.getServletContext();

        Assertions.assertNotNull(servletContext);

        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webAppContext.getBean("addressController"));
        this.mockMvc.perform(get("/addresses")).andDo(print())
                .andExpect(view().name("views/addressList"));
    }



    @Test
    void showform() throws Exception {
        ServletContext servletContext = webAppContext.getServletContext();

        Assertions.assertNotNull(servletContext);

        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webAppContext.getBean("addressController"));
        this.mockMvc.perform(get("/addresses/form")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("views/addressForm"));
    }

    @Test
    void save() throws Exception {
        Address add = new Address("444","Dbuois");

        this.mockMvc.perform(MockMvcRequestBuilderUtils.postForm("/addresses/save",add))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/addresses"));

        Address test = repository.findAddressByCivicNumber("444");

        Assertions.assertEquals("444",test.getCivicNumber());

        repository.delete(test);

    }

    @Test
    void edit() throws Exception {

        Address test = repository.findAddressByCivicNumber("555");

        mockMvc.perform(get("/addresses/edit/{id}", test.getId()))
                .andExpect(status().isOk());

    }


    @Test
    public void list() throws Exception {

        mockMvc.perform(get("/addresses"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/addressList"))
                .andExpect(model().attribute("addresses",hasSize(4)));

    }

    @Test
    void editsave() throws Exception {
        Address add = new Address("444","Dbuois");

        this.mockMvc.perform(MockMvcRequestBuilderUtils.postForm("/addresses/edit/save",add))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/addresses"));

        Address test = repository.findAddressByCivicNumber("444");

        Assertions.assertEquals("444",test.getCivicNumber());

        repository.delete(test);
    }

    @Test
    void delete() throws Exception {
        Address test = repository.findAddressByCivicNumber("555");
        this.mockMvc.perform(get("/addresses/delete/{id}",test.getId())).andDo(print())
                .andExpect(status().isFound());
    }
}