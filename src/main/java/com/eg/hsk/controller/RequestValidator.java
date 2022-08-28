package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateReservationDto;
import com.eg.hsk.misc.Constant;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RequestValidator {

    public void validate(CreateReservationDto dto) {

        if (!dto.reservationEnd.isAfter(dto.reservationBegin))
            throw new IllegalArgumentException("reservationEnd must be later than reservationBegin");

        if (dto.reservationBegin.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("reservationBegin must be later than now");

        if (dto.reservationBegin.getMinute() % Constant.MIN_RESERVATION_DURATION_IN_MINUTES !=0)
            throw new IllegalArgumentException("reservationBegin must be 0 or " + Constant.MIN_RESERVATION_DURATION_IN_MINUTES);

        if (dto.reservationEnd.getMinute() % Constant.MIN_RESERVATION_DURATION_IN_MINUTES !=0)
            throw new IllegalArgumentException("reservationEnd must be 0 or " + Constant.MIN_RESERVATION_DURATION_IN_MINUTES);
    }



}
