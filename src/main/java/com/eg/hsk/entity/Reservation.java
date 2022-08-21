package com.eg.hsk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Reservation extends BaseEntity {

    @ManyToOne(optional = false)
    private Pitch pitch;

    @Column(nullable = false)
    private LocalDateTime reservationBegin;

    @Column(nullable = false)
    private LocalDateTime reservationEnd;


    public Pitch getPitch() {
        return pitch;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public LocalDateTime getReservationBegin() {
        return reservationBegin;
    }

    public void setReservationBegin(LocalDateTime reservationBegin) {
        this.reservationBegin = reservationBegin;
    }

    public LocalDateTime getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        this.reservationEnd = reservationEnd;
    }
}
