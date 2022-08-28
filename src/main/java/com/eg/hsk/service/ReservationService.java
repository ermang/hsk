package com.eg.hsk.service;

import com.eg.hsk.dto.DailyTimeSlotDto;
import com.eg.hsk.dto.in.CreateReservationDto;
import com.eg.hsk.entity.Reservation;
import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.misc.Entity2Dto;
import com.eg.hsk.misc.TimeSlotGenerator;
import com.eg.hsk.repo.ReservationRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service
public class ReservationService {
    private final Dto2Entity dto2Entity;
    private final Entity2Dto entity2DTO;
    private final TimeSlotGenerator timeSlotGenerator;

    private final ReservationRepo reservationRepo;


    public ReservationService(Dto2Entity dto2Entity, Entity2Dto entity2DTO, TimeSlotGenerator timeSlotGenerator,
                              ReservationRepo reservationRepo) {
        this.dto2Entity = dto2Entity;
        this.entity2DTO = entity2DTO;
        this.timeSlotGenerator = timeSlotGenerator;
        this.reservationRepo = reservationRepo;
    }

    public void createReservation(CreateReservationDto createReservationDto) {

        List<Reservation> reservationList = reservationRepo.findAllByDateAndPitchId(createReservationDto.reservationBegin, createReservationDto.reservationEnd,
                createReservationDto.pitchId);

        if (!reservationList.isEmpty()) {
            throw new RuntimeException("lololo");
        }

        Reservation reservation = dto2Entity.createReservationDto2Reservation(createReservationDto);

        reservationRepo.save(reservation);
    }

    public DailyTimeSlotDto getDailyTImeSlotDto(long pitchId, LocalDate localDate) {

        LocalDateTime beginDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0));
        LocalDateTime endDateTime = beginDateTime.plusDays(1);
        List<Reservation> reservationList = reservationRepo.findAllByDateAndPitchId(beginDateTime, endDateTime, pitchId);

        DailyTimeSlotDto dto = timeSlotGenerator.generateDailyTimeSlotDTO(pitchId, localDate);
        timeSlotGenerator.updateDailyTimeSlotDTOWithReservations(dto, reservationList);

        return dto;
    }

}
