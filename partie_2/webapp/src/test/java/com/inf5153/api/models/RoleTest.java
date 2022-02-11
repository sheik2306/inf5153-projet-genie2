package com.inf5153.api.models;

import com.inf5153.api.repositories.RoleRepository;
import com.inf5153.api.services.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class RoleTest {

    @Autowired
    RoleService service;

    @MockBean
    private RoleRepository repository;

    @Test
    void getId() {
        Role role = new Role("Doctor");
        doReturn(role).when(repository).save(any());
        role.setId(5);
        Assertions.assertEquals(5,role.getId());
    }

    @Test
    void setId() {
        Role role = new Role("Doctor");
        doReturn(role).when(repository).save(any());
        role.setId(5);
        Assertions.assertEquals(5,role.getId());
    }

    @Test
    void getName() {
        Role role = new Role("Doctor");
        Assertions.assertEquals("Doctor",role.getName());
    }

    @Test
    void setName() {
        Role role = new Role("Doctor");
        role.setName("Patient");
        Assertions.assertNotEquals("Doctor",role.getName());
        Assertions.assertEquals("Patient",role.getName());
    }
}