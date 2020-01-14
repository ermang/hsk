package com.eg.hsk.misc;

import com.eg.hsk.dto.CreateReservationDTO;
import com.eg.hsk.dto.CreateStadiumDTO;
import com.eg.hsk.entity.Reservation;
import com.eg.hsk.entity.Stadium;
import com.eg.hsk.repo.StadiumRepo;
import org.springframework.stereotype.Component;

@Component
public class DTO2Entity {

    private final StadiumRepo stadiumRepo;

    public DTO2Entity(StadiumRepo stadiumRepo) {
        this.stadiumRepo = stadiumRepo;
    }

    public Stadium createStadiumDTO2Stadium(CreateStadiumDTO createStadiumDTO) {
        Stadium stadium = new Stadium();
        stadium.setLatitude(createStadiumDTO.latitude);
        stadium.setLongitude(createStadiumDTO.longitude);
        stadium.setCity(createStadiumDTO.city);
        stadium.setDistrict(createStadiumDTO.district);
        stadium.setAddress(createStadiumDTO.address);

        return stadium;
    }

    public Reservation createReservationDTO2Reservation(CreateReservationDTO createReservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setStadium(stadiumRepo.findById(createReservationDTO.stadiumId).get());
        reservation.setReservationDate(createReservationDTO.reservationDate);
        reservation.setBeginHour(createReservationDTO.beginHour);
        reservation.setEndHour(createReservationDTO.endHour);

        return reservation;
    }
}
