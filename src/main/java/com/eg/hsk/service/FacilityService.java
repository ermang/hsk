package com.eg.hsk.service;

import com.eg.hsk.dto.DailyTimeSlotDto;
import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.dto.in.CreateReservationDto;
import com.eg.hsk.dto.out.ReadPitchDto;
import com.eg.hsk.entity.*;
import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.misc.Entity2Dto;
import com.eg.hsk.misc.TimeSlotGenerator;
import com.eg.hsk.repo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {

    private final Dto2Entity dto2Entity;
    private final Entity2Dto entity2Dto;
    private final TimeSlotGenerator timeSlotGenerator;
    private final FacilityRepo facilityRepo;
    private final PitchRepo pitchRepo;
    private final CityRepo cityRepo;
    private final ReservationRepo reservationRepo;

    public FacilityService(Dto2Entity dto2Entity, Entity2Dto entity2Dto, TimeSlotGenerator timeSlotGenerator, FacilityRepo facilityRepo,
                           PitchRepo pitchRepo, CityRepo cityRepo, ReservationRepo reservationRepo) {
        this.dto2Entity = dto2Entity;
        this.entity2Dto = entity2Dto;
        this.timeSlotGenerator = timeSlotGenerator;
        this.facilityRepo = facilityRepo;
        this.pitchRepo = pitchRepo;
        this.cityRepo = cityRepo;
        this.reservationRepo = reservationRepo;
    }

    public void createFacility(CreateFacilityDto createFacilityDto) {
        Facility facility = dto2Entity.createFacilityDto2Facility(createFacilityDto);

        facilityRepo.save(facility);
    }

    public void createPitch(CreatePitchDto createPitchDto) {
        Pitch pitch = dto2Entity.createPitchDto2Pitch(createPitchDto);

        pitchRepo.save(pitch);
    }

    public void createCity(CreateCityDto createCityDto) {
        City city = dto2Entity.createCityDto2City(createCityDto);

        cityRepo.save(city);
    }

    public void createReservation(CreateReservationDto createReservationDto) {
        Reservation reservation = dto2Entity.createReservationDto2Reservation(createReservationDto);

        reservationRepo.save(reservation);
    }

    public DailyTimeSlotDto getDailyTImeSlotDto(long pitchId, LocalDate date) {

        LocalDateTime beginDateTime = LocalDateTime.of(date, LocalTime.of(0, 0));
        LocalDateTime endDateTime = beginDateTime.plusDays(1);
        List<Reservation> reservationList = reservationRepo.findAllByDateAndPitchId(beginDateTime, endDateTime, pitchId);

        DailyTimeSlotDto dto = timeSlotGenerator.generateDailyTimeSlotDTO(pitchId, date, reservationList);

        return dto;
    }

    public Page<ReadPitchDto>  searchPitch(long cityId, PitchType pitchType, Pageable pageable) {
        Page<AsdDto> pagedPitch = pitchRepo.findAllByCityIdAndPitchType(cityId, pitchType, pageable);

        List<ReadPitchDto> readPitchDtoList = new ArrayList<>();

//        for(Pitch p : pagedPitch.getContent()) {
//            ReadPitchDto rpd = entity2Dto.pitch2ReadPitchDto(pagedPitch.getContent().get(0));
//            readPitchDtoList.add(rpd);
//        }

        return null;
       // return new PageImpl<ReadPitchDto>(readPitchDtoList, pageable, pagedPitch.getTotalElements());
    }
}
