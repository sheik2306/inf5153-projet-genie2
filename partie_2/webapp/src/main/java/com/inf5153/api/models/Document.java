package com.inf5153.api.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Antecedant> antecedants;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Visit> visits;

    public Document(Patient patient) {
        this.patient = patient;
    }

    public Document() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Antecedant> getAntecedants() {
        return antecedants;
    }

    public void setAntecedants(Antecedant a) {
        if (antecedants == null) {
            this.antecedants = new ArrayList<>();
        }
        this.antecedants.add(a);
    }

    public List<Visit> getVisits() { return visits; }

    public void setVisits(Visit v) {
        if (visits == null) {
            this.visits  = new ArrayList<>();
         }
        this.visits.add(v);
    }
}
