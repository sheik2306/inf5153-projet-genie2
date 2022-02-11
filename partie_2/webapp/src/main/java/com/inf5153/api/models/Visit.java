package com.inf5153.api.models;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "visit_id")
    private Integer id;

    private Institution institution;

    private String doctor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;

    @Nullable
    private String diagnostic;

    @Nullable
    private String treatment;

    private String summary;

    private String notes;

    public Visit(Institution institution, String doctor, LocalDate visitDate, String diagnostic, String treatment, String summary, String notes) {
        this.institution = institution;
        this.doctor = doctor;
        this.visitDate = visitDate;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.summary = summary;
        this.notes = notes;
    }

    public Visit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) { 
        this.institution = institution;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getVisitDate() { return visitDate; }

    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }

    @Nullable
    public String getDiagnostic() { return diagnostic; }

    public void setDiagnostic(@Nullable String diagnostic) { this.diagnostic = diagnostic; }

    @Nullable
    public String getTreatment() { return treatment; }

    public void setTreatment(@Nullable String treatment) { this.treatment = treatment; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
