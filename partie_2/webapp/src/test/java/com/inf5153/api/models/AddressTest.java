package com.inf5153.api.models;

import com.inf5153.api.repositories.AddressRepository;
import com.inf5153.api.services.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class AddressTest {

    @Autowired
    AddressService service;

    @MockBean
    private AddressRepository repository;

    @Test
    void getId() {
        Address address = new Address("234","Dubois");
        doReturn(address).when(repository).save(any());
        address.setId(2);

        Assertions.assertEquals(2,address.getId());
    }

    @Test
    void setId() {
        Address address = new Address("234","Dubois");
        doReturn(address).when(repository).save(any());
        address.setId(2);

        Assertions.assertEquals(2,address.getId());
    }

    @Test
    void getCivicNumber() {
        Address address = new Address("234","Dubois");
        Assertions.assertEquals("234",address.getCivicNumber());
    }

    @Test
    void setCivicNumber() {
        Address address = new Address("234","Dubois");
        address.setCivicNumber("445");
        Assertions.assertEquals("445",address.getCivicNumber());
        Assertions.assertNotEquals("234",address.getCivicNumber());
    }

    @Test
    void getStreetName() {
        Address address = new Address("234","Dubois");
        Assertions.assertEquals("Dubois",address.getStreetName());

    }

    @Test
    void setStreetName() {
        Address address = new Address("234","Dubois");
        address.setStreetName("Lalo");
        Assertions.assertEquals("Lalo",address.getStreetName());
        Assertions.assertNotEquals("Dubois",address.getStreetName());
    }
}