package com.eg.hsk.misc;

import com.eg.hsk.dto.in.CreateReservationDto;
import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.entity.City;
import com.eg.hsk.entity.Facility;
import com.eg.hsk.entity.Pitch;
import com.eg.hsk.entity.Reservation;
import com.eg.hsk.repo.CityRepo;
import com.eg.hsk.repo.FacilityRepo;
import com.eg.hsk.repo.PitchRepo;
import com.eg.hsk.repo.ReservationRepo;
import org.springframework.stereotype.Component;

@Component
public class Dto2Entity {

    private final CityRepo cityRepo;
    private final FacilityRepo facilityRepo;
    private final PitchRepo pitchRepo;
    private final ReservationRepo reservationRepo;

    public Dto2Entity(CityRepo cityRepo, FacilityRepo facilityRepo, PitchRepo pitchRepo, ReservationRepo reservationRepo) {
        this.cityRepo = cityRepo;
        this.facilityRepo = facilityRepo;
        this.pitchRepo = pitchRepo;
        this.reservationRepo = reservationRepo;
    }

    public Facility createFacilityDto2Facility(CreateFacilityDto dto) {
        Facility f = new Facility();
        f.setName(dto.name);
        City c = cityRepo.findById(dto.cityId).get();
        f.setCity(c);

        return f;
    }

    public Pitch createPitchDto2Pitch(CreatePitchDto dto) {
        Pitch p = new Pitch();
        p.setPitchType(dto.pitchType);
        Facility f = facilityRepo.findById(dto.facilityId).get();
        p.setFacility(f);

        return p;
    }

    public City createCityDto2City(CreateCityDto createCityDto) {
        City c = new City();
        c.setName(createCityDto.name);

        return c;
    }

    public Reservation createReservationDto2Reservation(CreateReservationDto createReservationDto) {
        Reservation r = new Reservation();
        Pitch p = pitchRepo.findById(createReservationDto.pitchId).get();
        r.setPitch(p);
        r.setReservationBegin(createReservationDto.reservationBegin);
        r.setReservationEnd(createReservationDto.reservationEnd);

        return r;
    }
}
