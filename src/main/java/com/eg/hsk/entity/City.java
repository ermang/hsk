package com.eg.hsk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
