package com.inf5153.api.data;
import java.time.LocalDate;
import com.inf5153.api.daos.AddressDAO;
import com.inf5153.api.daos.AntecedantDAO;
import com.inf5153.api.daos.ContactDAO;
import com.inf5153.api.daos.VisitDAO;
import com.inf5153.api.models.*;
import com.inf5153.api.services.DocumentService;
import com.inf5153.api.services.PatientService;
import com.inf5153.api.services.DocumentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class seedDocument {

    @Autowired
    VisitDAO visitDAO;

    @Autowired
    AntecedantDAO antecedantDAO;

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    ContactDAO contactDAO;

    @Autowired
    PatientService patientService;

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentHistoryService documentHistoryService;




    @EventListener
    private void loadUserData(ContextRefreshedEvent event) {
        if (patientService.count() == 0) {

            Address add = new Address("250","test");
            Address add1 = new Address("199","ok");
            Address add2 = new Address("2700","Pie-IX");

            addressDAO.save(add);
            addressDAO.save(add1);
            addressDAO.save(add2);

            Contact contact = new Contact(add, "514-123-1234", "test@test.com");
            Contact contact1 = new Contact(add1, "438-666-9876", "ok@ok.com");
            Contact contact2 = new Contact(add2, "444-666-9876", "youhoo@outlook.com");

            contactDAO.save(contact);
            contactDAO.save(contact1);
            contactDAO.save(contact2);

            String[] parents = {"Marise Test", "Maurice Test"};
            String[] parents1 = {"Julie Test", "Jules Test"};
            String[] parents2 = {"Mark Andree", "Jeff"};

            Patient user = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
            Patient user1 = new Patient("Testi", "Testo", Gender.Other, parents1, "Montreal", contact1, "tte1234");
            Patient user2 = new Patient("Jeff", "Bezos", Gender.Other, parents2, "Montreal", contact2, "JEFF34506");
            user.setMedicalDate(LocalDate.of(2022, 6, 24));
            user1.setMedicalDate(LocalDate.of(2020, 6, 24));
            user2.setMedicalDate(LocalDate.of(2019, 6, 24));
            patientService.createOrSave(user);
            patientService.createOrSave(user1);
            patientService.createOrSave(user2);

            LocalDate dv1 = LocalDate.of(2021, 6, 24);
            LocalDate dv2 = LocalDate.of(2021, 7, 18);
            LocalDate dv3 = LocalDate.of(2021, 3, 15);
            LocalDate dv4 = LocalDate.of(2021, 3, 28);

            Visit visit = new Visit(Institution.HOTEL_DIEU, "Dr.Test", dv1, "Covid", "Confinement",
                    "Covid contracte par le patient", "14 jours confinement");
            Visit visit1 = new Visit(Institution.JEAN_TALON_HOSPITAL, "Dr.Assistant", dv2, "Grippe", "Repos",
                    "Grippe severe", "test covid negatif");

            Visit visit2 = new Visit(Institution.HOTEL_DIEU, "Dr.Ok", dv1, "Covid", "Confinement",
                    "Covid contracte par le patient", "14 jours confinement");
            Visit visit3 = new Visit(Institution.JEAN_TALON_HOSPITAL, "Dr.Assistant", dv2, "Grippe", "Repos",
                    "Grippe severe", "test covid negatif");
            Visit visit4 = new Visit(Institution.HOTEL_DIEU, "Dr.buddy", dv1, "Covid", "Confinement",
                    "Covid contracte par le patient", "14 jours confinement");
            Visit visit5 = new Visit(Institution.JEAN_TALON_HOSPITAL, "Dr.Assistant", dv2, "Grippe", "Repos",
                    "Grippe severe", "test covid negatif");

            Antecedant antecedant = new Antecedant("Covid-19", "Confinement", "Dr.Test", dv1, dv2);
            Antecedant antecedant1 = new Antecedant("Cancer du colon", "Chimiothérapie", "Dr.Assistant", dv3, dv4);

            Document document = new Document();


            // OneToMany and ManyToOne relation, (setters) for both models
            // Save only on the Document side.
            visit.setDocument(document);
            visit1.setDocument(document);
            document.setVisits(visit);
            document.setVisits(visit1);
            antecedant.setDocument(document);
            document.setAntecedants(antecedant);
            document.setPatient(user);

            documentService.createOrSave(document);


             Document document1 = new Document();
             visit2.setDocument(document1);
             visit3.setDocument(document1);
             document1.setVisits(visit2);
             document1.setVisits(visit3);
             antecedant1.setDocument(document1);
             document1.setAntecedants(antecedant1);
             document1.setPatient(user1);
             DocumentHistory documentHistory1 = new DocumentHistory(document1);
             documentService.createOrSave(document1);
             documentHistoryService.createOrSave(documentHistory1);


            DocumentHistory documentHistory = new DocumentHistory(document);
            documentService.createOrSave(document);
            documentHistoryService.createOrSave(documentHistory);



            Document document2 = new Document();
            visit4.setDocument(document2);
            visit5.setDocument(document2);
            document2.setVisits(visit4);
            document2.setVisits(visit5);
            document2.setPatient(user2);
            DocumentHistory documentHistory2 = new DocumentHistory(document2);
            documentService.createOrSave(document2);
            documentHistoryService.createOrSave(documentHistory2);
                
        }
    }
}
