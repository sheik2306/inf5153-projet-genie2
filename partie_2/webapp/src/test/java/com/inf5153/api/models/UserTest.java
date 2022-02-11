package com.inf5153.api.models;

import com.inf5153.api.repositories.RoleRepository;
import com.inf5153.api.repositories.UserRepository;
import com.inf5153.api.services.RoleService;
import com.inf5153.api.services.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class UserTest {

    @Autowired
    UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    void getId() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        doReturn(user).when(repository).save(any());
        user.setId(5);
        Assertions.assertEquals(5,user.getId());
    }

    @Test
    void setId() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        doReturn(user).when(repository).save(any());
        user.setId(5);
        Assertions.assertEquals(5,user.getId());
    }

    @Test
    void getUserName() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        Assertions.assertEquals("user",user.getUserName());
    }

    @Test
    void setUserName() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles); 
        user.setUserName("user2");       
        Assertions.assertNotEquals("user",user.getUserName());
        Assertions.assertEquals("user2",user.getUserName());
    }


    @Test
    void getPassword() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        Assertions.assertEquals("password",user.getPassword());
    }

    @Test
    void setPassword() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        user.setPassword("password2");
        Assertions.assertNotEquals("password",user.getPassword());
        Assertions.assertEquals("password2",user.getPassword());
    }

    @Test
    void getRoles() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        user.setRoles(roles);
        Assertions.assertEquals(roles,user.getRoles());
    }

    @Test
    void setRoles() {
        Role role = new Role("Doctor");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User("user", "password", roles);
        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role("Patient"));
        user.setRoles(roles2);
        Assertions.assertEquals(roles2,user.getRoles());
        Assertions.assertNotEquals(roles,user.getRoles());
    }
}