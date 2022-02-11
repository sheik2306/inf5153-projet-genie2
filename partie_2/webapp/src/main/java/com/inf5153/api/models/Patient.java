package com.inf5153.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Gender gender;

    private String[] parents = new String[2];

    private String birthCity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @NotBlank(message = "Medical Card is mandatory")
    private String medicalCard;



    private LocalDate medicalDate;

    public Patient() {
        
    }

    public Patient(String firstName, String lastName, Gender gender, String[] parents, String birthCity, Contact contact, String medicalCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.parents = parents;
        this.birthCity = birthCity;
        this.contact = contact;
        this.medicalCard = medicalCard;
    }

    public LocalDate getMedicalDate() {
        return medicalDate;
    }

    public void setMedicalDate(LocalDate medicalDate) {
        this.medicalDate = medicalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }
}
