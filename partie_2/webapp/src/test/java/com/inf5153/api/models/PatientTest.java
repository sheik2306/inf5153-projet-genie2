package com.inf5153.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void getId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setId(1);

        Assertions.assertEquals(1,patient.getId());
    }

    @Test
    void setId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setId(2);

        Assertions.assertEquals(2,patient.getId());
        Assertions.assertNotEquals(1, patient.getId());
    }

    @Test
    void getFirstName() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals("John",patient.getFirstName());
    }

    @Test
    void setFirstName() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setFirstName("Jim");

        Assertions.assertEquals("Jim",patient.getFirstName());
        Assertions.assertNotEquals("John", patient.getFirstName());
    }

    @Test
    void getLastName() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals("Doe",patient.getLastName());
    }

    @Test
    void setLastName() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setLastName("Koli");

        Assertions.assertEquals("Koli",patient.getLastName());
        Assertions.assertNotEquals("Doe", patient.getLastName());
    }

    @Test
    void getGender() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals(Gender.Male, patient.getGender());
    }

    @Test
    void setGender() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setGender(Gender.Other);

        Assertions.assertEquals(Gender.Other, patient.getGender());
        Assertions.assertNotEquals(Gender.Male, patient.getGender());
    }

    @Test
    void getParents() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals(parents, patient.getParents());
    }

    @Test
    void setParents() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        String[] parents1 = {"Julie Test", "Jules Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setParents(parents1);

        Assertions.assertEquals(parents1, patient.getParents());
        Assertions.assertNotEquals(parents, patient.getParents());
    }

    @Test
    void getBirthCity() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals("Montreal", patient.getBirthCity());
    }

    @Test
    void setBirthCity() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setBirthCity("Magog");

        Assertions.assertEquals("Magog", patient.getBirthCity());
        Assertions.assertNotEquals("Montreal", patient.getBirthCity());
    }

    @Test
    void getContact() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals(contact, patient.getContact());
    }

    @Test
    void setContact() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        Contact contact1 = new Contact(add, "438-666-9876", "ok@ok.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setContact(contact1);

        Assertions.assertEquals(contact1, patient.getContact());
        Assertions.assertNotEquals(contact, patient.getContact());
    }

    @Test
    void getMedicalCard() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");

        Assertions.assertEquals("doe1445",patient.getMedicalCard());
    }

    @Test
    void setMedicalCard() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        patient.setMedicalCard("dub305");

        Assertions.assertEquals("dub305",patient.getMedicalCard());
        Assertions.assertNotEquals("doe1445", patient.getMedicalCard());
    }
}