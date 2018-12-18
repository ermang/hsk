package egcom.hsk.misc;

import egcom.hsk.dto.CreateReservationDTO;
import egcom.hsk.dto.CreateStadiumDTO;
import egcom.hsk.entity.Reservation;
import egcom.hsk.entity.Stadium;
import egcom.hsk.repository.StadiumRepo;
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
