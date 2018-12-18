package egcom.hsk.repository;

import egcom.hsk.entity.Reservation;
import egcom.hsk.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepo extends JpaRepository<Stadium, Long> {
}
