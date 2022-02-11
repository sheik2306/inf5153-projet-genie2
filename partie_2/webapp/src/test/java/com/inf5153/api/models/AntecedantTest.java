package com.inf5153.api.models;

import com.inf5153.api.repositories.AntecedantRepository;
import com.inf5153.api.services.AntecedantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class AntecedantTest {

    @Autowired
    AntecedantService service;

    @MockBean
    private AntecedantRepository repository;

    @Test
    void getId() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        doReturn(antecedant).when(repository).save(any());
        antecedant.setId(2);

        assertEquals(2, antecedant.getId());
    }

    @Test
    void setId() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        doReturn(antecedant).when(repository).save(any());
        antecedant.setId(2);

        assertEquals(2, antecedant.getId());
    }

    @Test
    void getDiagnostic() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);

        assertEquals("Covid-19", antecedant.getDiagnostic());
    }

    @Test
    void setDiagnostic() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        antecedant.setDiagnostic("Grippe");

        assertEquals("Grippe", antecedant.getDiagnostic());
        assertNotEquals("Covid-19", antecedant.getDiagnostic());
    }

    @Test
    void getTreatment() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);

        assertEquals("Confinement", antecedant.getTreatment());

    }

    @Test
    void setTreatment() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        antecedant.setTreatment("14 jours confinement");

        assertEquals("14 jours confinement", antecedant.getTreatment());
        assertNotEquals("Confinement", antecedant.getTreatment());
    }

    @Test
    void getDoctor() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);

        assertEquals("Dr.Test", antecedant.getDoctor());
    }

    @Test
    void setDoctor() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        antecedant.setDoctor("Assistant");

        assertEquals("Assistant", antecedant.getDoctor());
        assertNotEquals("Dr.Test", antecedant.getDoctor());
    }

    @Test
    void getSicknessStart() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);

        assertEquals(d1, antecedant.getSicknessStart());

    }

    @Test
    void setSicknessStart() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        LocalDate d3 = LocalDate.of(2021, 6, 3);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        antecedant.setSicknessStart(d3);

        assertEquals(d3, antecedant.getSicknessStart());
        assertNotEquals(d1, antecedant.getSicknessStart());
    }

    @Test
    void getSicknessEnd() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);

        assertEquals(d2, antecedant.getSicknessEnd());

    }

    @Test
    void setSicknessEnd() {
        LocalDate d1 = LocalDate.of(2021, 6, 9);
        LocalDate d2 = LocalDate.of(2021, 6, 24);
        LocalDate d3 = LocalDate.of(2021, 6, 18);
        Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", d1, d2);
        antecedant.setSicknessEnd(d3);

        assertEquals(d3, antecedant.getSicknessEnd());
        assertNotEquals(d1, antecedant.getSicknessEnd());
    }
}
