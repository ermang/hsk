package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateReservationDto;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public void validate(CreateReservationDto dto) {

        if (!dto.reservationEnd.isAfter(dto.reservationBegin))
            throw new IllegalArgumentException("reservationEnd must be later than reservationBegin");
    }


}
