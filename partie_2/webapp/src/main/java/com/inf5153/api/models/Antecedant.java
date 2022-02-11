package com.inf5153.api.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="antecedants")
public class Antecedant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "antecedant_id")
    private Integer id;

    private String diagnostic;
    private String treatment;

    //Pour l'instant j'ai pas de docteur implémenté dans ma branch
    //private Doctor doctor;
    //En attendant juste un String pour le nom
    private String doctor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Nullable
    private LocalDate sicknessStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Nullable
    private LocalDate sicknessEnd;

    public Antecedant(String diagnostic, String treatment, String doctor, LocalDate sicknessStart, LocalDate sicknessEnd){
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.doctor = doctor;
        this.sicknessStart = sicknessStart;
        this.sicknessEnd = sicknessEnd;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    public Antecedant() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getSicknessStart() {
        return sicknessStart;
    }

    public void setSicknessStart(LocalDate sicknessStart) {
        this.sicknessStart = sicknessStart;
    }

    public LocalDate getSicknessEnd() {
        return sicknessEnd;
    }

    public void setSicknessEnd(LocalDate sicknessEnd) {
        this.sicknessEnd = sicknessEnd;
    }


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
