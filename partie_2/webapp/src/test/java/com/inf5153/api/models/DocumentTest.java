package com.inf5153.api.models;

import com.inf5153.api.repositories.DocumentRepository;
import com.inf5153.api.services.DocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class DocumentTest {

    @Autowired
    DocumentService service;

    @MockBean
    private DocumentRepository repository;

    @Test
    void getId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(user);
        doReturn(document).when(repository).save(any());
        document.setId(2);

        assertEquals(2, document.getId());
    }

    @Test
    void setId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(user);
        doReturn(document).when(repository).save(any());
        document.setId(2);

        assertEquals(2, document.getId());
    }

    @Test
    void getPatient() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(user);

        assertEquals(user, document.getPatient());
    }

    @Test
    void setPatient() {
        Address add = new Address("250","test");
        Address add1 = new Address("199","ok");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        Contact contact1 = new Contact(add1, "438-666-9876", "ok@ok.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        String[] parents1 = {"Julie Test", "Jules Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Patient user1 = new Patient("Testi", "Testo", Gender.Other, parents1, "Montreal", contact1, "tte1234");
        Document document = new Document(user);
        document.setPatient(user1);

        assertEquals(user1, document.getPatient());
        assertNotEquals(user, document.getPatient());
    }

    @Test
    void getAntecedants() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        Antecedant antecedant1 = new Antecedant("Grippe", "Repos", "Dr.Assistant", d1, d2);
        Document document = new Document(user);
        document.setAntecedants(antecedant);
        document.setAntecedants(antecedant1);
        ArrayList<Antecedant> listAntecedants = new ArrayList<>();
        listAntecedants.add(antecedant);
        listAntecedants.add(antecedant1);

        assertEquals(listAntecedants, document.getAntecedants());
    }

    @Test
    void setAntecedants() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        Antecedant antecedant1 = new Antecedant("Grippe", "Repos", "Dr.Assistant", d1, d2);
        Document document = new Document(user);
        document.setAntecedants(antecedant);
        document.setAntecedants(antecedant1);
        ArrayList<Antecedant> listAntecedants = new ArrayList<>();
        listAntecedants.add(antecedant);
        listAntecedants.add(antecedant1);

        assertEquals(listAntecedants, document.getAntecedants());
    }

    @Test
    void getVisits() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        LocalDate dv1 = LocalDate.of(2021, 6, 24);
        LocalDate dv2 = LocalDate.of(2021, 7, 18);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", dv1, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        Visit visit1 = new Visit(Institution.JEAN_TALON_HOSPITAL, "Dr.Assistant", dv2, "Grippe", "Repos",
                "Grippe severe", "test covid negatif");
        Document document = new Document(user);
        document.setVisits(visit);
        document.setVisits(visit1);
        ArrayList<Visit> listVisits = new ArrayList<>();
        listVisits.add(visit);
        listVisits.add(visit1);

        assertEquals(listVisits, document.getVisits());
    }

    @Test
    void setVisits() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        LocalDate dv1 = LocalDate.of(2021, 6, 24);
        LocalDate dv2 = LocalDate.of(2021, 7, 18);
        Visit visit = new Visit(Institution.JEWEISH_GENERAL_HOSPITAL, "Dr.Test", dv1, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        Visit visit1 = new Visit(Institution.LACHINE_HOSPITAL, "Dr.Assistant", dv2, "Grippe", "Repos",
                "Grippe severe", "test covid negatif");
        Document document = new Document(user);
        document.setVisits(visit);
        document.setVisits(visit1);
        ArrayList<Visit> listVisits = new ArrayList<>();
        listVisits.add(visit);
        listVisits.add(visit1);

        assertEquals(listVisits, document.getVisits());
    }
}
