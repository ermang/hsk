package egcom.hsk.repository;

import egcom.hsk.dto.StadiumDTO;
import egcom.hsk.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StadiumRepo extends JpaRepository<Stadium, Long> {

    List<StadiumDTO> findAllByCity(String city);
    List<StadiumDTO> findAllByCityAndDistrict(String city, String district);
}
