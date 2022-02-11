package com.inf5153.api.models;

import com.inf5153.api.repositories.DocumentHistoryRepository;
import com.inf5153.api.services.DocumentHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import java.time.LocalDateTime;

@SpringBootTest
class DocumentHistoryTest {

    @Autowired
    DocumentHistoryService service;

    @MockBean
    private DocumentHistoryRepository repository;

    @Test
    void getId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);
        DocumentHistory documentHistory = new DocumentHistory(document);
        doReturn(documentHistory).when(repository).save(any());
        documentHistory.setId(2);

        assertEquals(2, documentHistory.getId());
    }

    @Test
    void setId() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);
        
        DocumentHistory documentHistory = new DocumentHistory(document);
        doReturn(documentHistory).when(repository).save(any());
        documentHistory.setId(2);

        assertEquals(2, documentHistory.getId());
    }

    @Test
    void getDocument() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);

        DocumentHistory documentHistory = new DocumentHistory(document);
        doReturn(documentHistory).when(repository).save(any());

        assertEquals(document, documentHistory.getDocument());
    }

    @Test
    void setDocument() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);

        Address add1 = new Address("250","test");
        Contact contact1 = new Contact(add1, "514-123-1234", "test@test.com");
        String[] parents1 = {"Marise Test", "Maurice Test"};
        Patient patient1 = new Patient("John", "Doe", Gender.Male, parents1, "Montreal", contact1 , "doe1445");
        Document document1 = new Document(patient1);
        DocumentHistory documentHistory = new DocumentHistory(document);
        doReturn(documentHistory).when(repository).save(any());
        documentHistory.setDocument(document1);

        assertEquals(document1, documentHistory.getDocument());
    }

    @Test
    void getModificationDate() {
        Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);

        DocumentHistory documentHistory = new DocumentHistory(document);
        LocalDateTime date = LocalDateTime.now();
        doReturn(documentHistory).when(repository).save(any());
        assertEquals(date.withNano(0), documentHistory.getModificationDate().withNano(0));
    }

    @Test
    void setModificationDate() {
       Address add = new Address("250","test");
        Contact contact = new Contact(add, "514-123-1234", "test@test.com");
        String[] parents = {"Marise Test", "Maurice Test"};
        Patient patient = new Patient("John", "Doe", Gender.Male, parents, "Montreal", contact , "doe1445");
        Document document = new Document(patient);
        
        DocumentHistory documentHistory = new DocumentHistory(document);
        doReturn(documentHistory).when(repository).save(any());
        documentHistory.setModificationDate(LocalDateTime.now());
        LocalDateTime date = LocalDateTime.now();
        assertEquals(date.withNano(0), documentHistory.getModificationDate().withNano(0));
    }
}