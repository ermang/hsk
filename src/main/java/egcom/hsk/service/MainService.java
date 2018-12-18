package egcom.hsk.service;

import egcom.hsk.dto.CreateReservationDTO;
import egcom.hsk.dto.CreateStadiumDTO;
import egcom.hsk.entity.Reservation;
import egcom.hsk.entity.Stadium;
import egcom.hsk.misc.DTO2Entity;
import egcom.hsk.repository.ReservationRepo;
import egcom.hsk.repository.StadiumRepo;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final DTO2Entity dto2Entity;
    private final StadiumRepo stadiumRepo;
    private final ReservationRepo reservationRepo;


    public MainService(DTO2Entity dto2Entity, StadiumRepo stadiumRepo, ReservationRepo reservationRepo) {
        this.dto2Entity = dto2Entity;
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


}
