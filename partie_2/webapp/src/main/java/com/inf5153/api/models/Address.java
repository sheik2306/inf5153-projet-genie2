package com.inf5153.api.models;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer id;

    private String civicNumber;
    private String streetName;

    public Address(String civicNumber, String streetName) {
        this.civicNumber = civicNumber;
        this.streetName = streetName;
    }

    public Address() {
        
    } 
    
    @OneToOne(mappedBy = "address")
    private Contact contact;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCivicNumber() {
        return this.civicNumber;
    }

    public void setCivicNumber(String civicNumber) {
        this.civicNumber = civicNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


}
