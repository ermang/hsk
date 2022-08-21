package com.eg.hsk.entity;

import javax.persistence.*;

@Entity
public class Pitch extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PitchType pitchType;

    @ManyToOne(optional = false)
    private Facility facility;


    public PitchType getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchType pitchType) {
        this.pitchType = pitchType;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
