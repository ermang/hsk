package com.eg.hsk;

import com.eg.hsk.dto.CreateReservationDTO;
import com.eg.hsk.dto.CreateStadiumDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestFactory {

    public CreateStadiumDTO createStadiumDTO() {
        CreateStadiumDTO createStadiumDTO = new CreateStadiumDTO();
        createStadiumDTO.latitude = 1;
        createStadiumDTO.longitude = 1;
        createStadiumDTO.city = "istanbul";
        createStadiumDTO.district = "maltepe";
        createStadiumDTO.address = "address";

        return createStadiumDTO;
    }

    public CreateReservationDTO createReservationDTO() {
        CreateReservationDTO createReservationDTO = new CreateReservationDTO();
        createReservationDTO.stadiumId = 1;
        createReservationDTO.reservationDate = LocalDate.now();
        createReservationDTO.beginHour = LocalTime.now();
        createReservationDTO.endHour = LocalTime.now();

        return createReservationDTO;
    }
}
