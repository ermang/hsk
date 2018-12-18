package egcom.hsk.repository;

import egcom.hsk.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByStadiumIdAndReservationDate(Long stadiumId, LocalDate reservationDate);
}
