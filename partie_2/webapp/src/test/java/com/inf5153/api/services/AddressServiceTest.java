package com.inf5153.api.services;

import com.inf5153.api.models.Address;
import com.inf5153.api.repositories.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class AddressServiceTest {

    @Autowired
    AddressService service;

    @MockBean
    private AddressRepository repository;

    @Test
    void fetchAll() {
        // Setup our mock repository
        Address address = new Address("234","Dubois");
        Address address2 = new Address("234","Dubois");
        doReturn(Arrays.asList(address, address2)).when(repository).findAll();

        List<Address> addresses = service.fetchAll();
    service.createOrSave(address);
        Assertions.assertEquals(2,addresses.size());


    }

    @Test
    void fetchOneById() {

            Address address = new Address("234","Dubois");
            doReturn(Optional.of(address)).when(repository).findById(1);
            //Service call
            Optional<Address> add = Optional.ofNullable(service.fetchOneById(1));

            Assertions.assertTrue(add.isPresent(), "Widget was not found");
            Assertions.assertSame(add.get(), address, "The widget returned was not the same as the mock");


    }

    @Test
    void createOrSave() {
        Address address = new Address("234","Dubois");
        doReturn(address).when(repository).save(any());

       Address returnedAddress =  service.createOrSave(address);
       Assertions.assertNotNull(returnedAddress, "The saved widget should not be null");
    }

    @Test
    void delete() {
        Address address = new Address("234","Dubois");
        doReturn(address).when(repository).save(any());

        service.delete(1);

        Assertions.assertEquals(0,service.count());
    }

    @Test
    void count() {
    }
}