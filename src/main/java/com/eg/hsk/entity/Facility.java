package com.eg.hsk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Facility extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    private City city;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
