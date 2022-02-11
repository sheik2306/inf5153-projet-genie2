package com.inf5153.api.models;

import javax.persistence.*;

@Entity
@Table(name="Roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Role() {
        
    }

    public Role(String name) {
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
