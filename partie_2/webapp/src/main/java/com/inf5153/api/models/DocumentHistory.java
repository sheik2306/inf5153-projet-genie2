package com.inf5153.api.models;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="document_history")
public class DocumentHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_history_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_id")
    private Document document;

    private LocalDateTime modificationDate;

    public DocumentHistory(Document document) {
        this.document = document;
        this.modificationDate = LocalDateTime.now();
    }
    

    public DocumentHistory() {
        this.modificationDate = LocalDateTime.now();
    } 
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(LocalDateTime date) {
        this.modificationDate = date;
    }
}
