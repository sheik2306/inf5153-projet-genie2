package com.inf5153.api.models;

import com.inf5153.api.repositories.AntecedantRepository;
import com.inf5153.api.repositories.VisitRepository;
import com.inf5153.api.services.AntecedantService;
import com.inf5153.api.services.VisitService;
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
class VisitTest {

    @Autowired
    VisitService service;

    @MockBean
    private VisitRepository repository;

    @Test
    void getId() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        doReturn(visit).when(repository).save(any());
        visit.setId(2);

        assertEquals(2, visit.getId());
    }

    @Test
    void setId() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setId(2);

        assertEquals(2, visit.getId());
    }

    @Test
    void getInstitution() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals(Institution.HOTEL_DIEU.institutionShow(), visit.getInstitution().institutionShow());

    }

    @Test
    void setInstitution() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setInstitution(Institution.JEAN_TALON_HOSPITAL);

        assertEquals(Institution.JEAN_TALON_HOSPITAL.institutionShow(), visit.getInstitution().institutionShow());
        assertNotEquals(Institution.HOTEL_DIEU.institutionShow(), visit.getInstitution().institutionShow());
    }

    @Test
    void getDoctor() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals("Dr.Test", visit.getDoctor());
    }

    @Test
    void setDoctor() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setDoctor("Assistant");

        assertEquals("Assistant", visit.getDoctor());
        assertNotEquals("Dr.Test", visit.getDoctor());
    }

    @Test
    void getVisitDate() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setDoctor("Assistant");

        assertEquals(d, visit.getVisitDate());
    }

    @Test
    void setVisitDate() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        LocalDate d2 = LocalDate.of(2021, 7, 18);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setVisitDate(d2);

        assertEquals(d2, visit.getVisitDate());
        assertNotEquals(d, visit.getVisitDate());
    }

    @Test
    void getDiagnostic() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals("Covid", visit.getDiagnostic());
    }

    @Test
    void setDiagnostic() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setDiagnostic("Grippe");

        assertEquals("Grippe", visit.getDiagnostic());
        assertNotEquals("Covid", visit.getDiagnostic());
    }

    @Test
    void getTreatment() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals("Confinement", visit.getTreatment());
    }

    @Test
    void setTreatment() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setTreatment("Hospitalisation");

        assertEquals("Hospitalisation", visit.getTreatment());
        assertNotEquals("Confinement", visit.getTreatment());
    }

    @Test
    void getSummary() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals("Covid contracte par le patient", visit.getSummary());
    }

    @Test
    void setSummary() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setSummary("Grippe severe");

        assertEquals("Grippe severe", visit.getSummary());
        assertNotEquals("Covid contracte par le patient", visit.getSummary());
    }

    @Test
    void getNotes() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");

        assertEquals("14 jours confinement", visit.getNotes());
    }

    @Test
    void setNotes() {
        LocalDate d = LocalDate.of(2021, 6, 24);
        Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", d, "Covid", "Confinement",
                "Covid contracte par le patient", "14 jours confinement");
        visit.setNotes("Symptomes severes");

        assertEquals("Symptomes severes", visit.getNotes());
        assertNotEquals("14 jours confinement", visit.getNotes());
    }
}
