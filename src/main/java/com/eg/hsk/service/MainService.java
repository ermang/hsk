package com.eg.hsk.service;

import com.eg.hsk.dto.CreateReservationDTO;
import com.eg.hsk.dto.CreateStadiumDTO;
import com.eg.hsk.dto.DailyTimeSlotDTO;
import com.eg.hsk.dto.StadiumDTO;
import com.eg.hsk.entity.Reservation;
import com.eg.hsk.entity.Stadium;
import com.eg.hsk.misc.DTO2Entity;
import com.eg.hsk.misc.Entity2DTO;
import com.eg.hsk.misc.TimeSlotGenerator;
import com.eg.hsk.repo.ReservationRepo;
import com.eg.hsk.repo.StadiumRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MainService {
    private final DTO2Entity dto2Entity;
    private final Entity2DTO entity2DTO;
    private final TimeSlotGenerator timeSlotGenerator;
    private final StadiumRepo stadiumRepo;
    private final ReservationRepo reservationRepo;


    public MainService(DTO2Entity dto2Entity, Entity2DTO entity2DTO, TimeSlotGenerator timeSlotGenerator,
                       StadiumRepo stadiumRepo, ReservationRepo reservationRepo) {
        this.dto2Entity = dto2Entity;
        this.entity2DTO = entity2DTO;
        this.timeSlotGenerator = timeSlotGenerator;
        this.stadiumRepo = stadiumRepo;
        this.reservationRepo = reservationRepo;
    }

    public Long createStadium(CreateStadiumDTO createStadiumDTO) {
        Stadium stadium = dto2Entity.createStadiumDTO2Stadium(createStadiumDTO);
        stadium= stadiumRepo.save(stadium);

        return stadium.getId();
    }

    public Long createReservation(CreateReservationDTO createReservationDTO) {
        Reservation reservation = dto2Entity.createReservationDTO2Reservation(createReservationDTO);
        reservation = reservationRepo.save(reservation);

        return reservation.getId();
    }

    public List<Stadium> readAllStadiums() {
        return stadiumRepo.findAll();
    }

    public List<StadiumDTO> readStadiumsByCity(String city) {
        List<StadiumDTO> stadiumDTOs = stadiumRepo.findAllByCity(city);

        return stadiumDTOs;
    }

    public List<StadiumDTO> readStadiumsByCityAndDistrict(String city, String district) {
        List<StadiumDTO> stadiumDTOs = stadiumRepo.findAllByCityAndDistrict(city, district);

        return stadiumDTOs;
    }

    public List<Reservation> readReservations(Long stadiumId, LocalDate reservationDate) {
        List<Reservation> reservations = reservationRepo.findAllByStadiumIdAndReservationDate(stadiumId, reservationDate);

        return reservations;
    }

    public DailyTimeSlotDTO readTimeSlots(Long stadiumId, LocalDate reservationDate) {
        List<Reservation> reservations = reservationRepo.findAllByStadiumIdAndReservationDate(stadiumId, reservationDate);
        DailyTimeSlotDTO dailyTimeSlotDTO = timeSlotGenerator.dailyTimeSlotDTO(stadiumId);
        dailyTimeSlotDTO = timeSlotGenerator.updateWithReservations(dailyTimeSlotDTO, reservations);

        return dailyTimeSlotDTO;
    }
}
