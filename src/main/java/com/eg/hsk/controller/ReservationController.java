package com.eg.hsk.controller;

import com.eg.hsk.dto.DailyTimeSlotDto;
import com.eg.hsk.dto.in.CreateReservationDto;
import com.eg.hsk.service.FacilityService;
import com.eg.hsk.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping(path = "/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void createReservation(@RequestBody CreateReservationDto createReservationDto) {
        reservationService.createReservation(createReservationDto);
    }

    @GetMapping(path = "/pitchId/{pitchId}/date/{date}")
    public DailyTimeSlotDto getDailyReservation(@PathVariable long pitchId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return reservationService.getDailyTImeSlotDto(pitchId, date);
    }
}
