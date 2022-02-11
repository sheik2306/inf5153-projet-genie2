package com.inf5153.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {

    @Test
    void getId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        contact.setId(1);

        Assertions.assertEquals(1,contact.getId());
    }

    @Test
    void setId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        contact.setId(2);

        Assertions.assertEquals(2,contact.getId());
        Assertions.assertNotEquals(1, contact.getId());
    }

    @Test
    void getAddress() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");

        Assertions.assertEquals(add,contact.getAddress());
    }

    @Test
    void setAddress() {
        Address add = new Address("250","test");
        Address add1 = new Address("199","ok");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        contact.setAddress(add1);

        Assertions.assertEquals(add1,contact.getAddress());
        Assertions.assertNotEquals(add, contact.getAddress());
    }

    @Test
    void getPhoneNumber() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");

        Assertions.assertEquals("514-123-1234",contact.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        contact.setPhoneNumber("438-666-9876");

        Assertions.assertEquals("438-666-9876",contact.getPhoneNumber());
        Assertions.assertNotEquals("514-123-1234", contact.getPhoneNumber());
    }

    @Test
    void getEmail() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");

        Assertions.assertEquals("test@test.com",contact.getEmail());
    }

    @Test
    void setEmail() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        contact.setEmail("ok@ok.com");

        Assertions.assertEquals("ok@ok.com",contact.getEmail());
        Assertions.assertNotEquals("test@test.com", contact.getEmail());
    }

}
