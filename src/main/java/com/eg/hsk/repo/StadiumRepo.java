package com.eg.hsk.repo;

import com.eg.hsk.dto.StadiumDTO;
import com.eg.hsk.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StadiumRepo extends JpaRepository<Stadium, Long> {

    List<StadiumDTO> findAllByCity(String city);
    List<StadiumDTO> findAllByCityAndDistrict(String city, String district);
}
