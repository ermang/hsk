package com.eg.hsk.repo;

import com.eg.hsk.entity.Pitch;
import com.eg.hsk.entity.PitchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PitchRepo extends JpaRepository<Pitch, Long> {

    //@Query(value = "SELECT p from Pitch p WHERE p.facility.city.id = :cityId AND p.pitchType = :pitchType")
    @Query(value = "SELECT p from Pitch p " +
            "INNER JOIN FETCH Facility f ON p.facility.id = f.id " +
            "INNER JOIN FETCH City c ON f.city.id = c.id AND c.id = :cityId " +
            "WHERE p.pitchType = :pitchType")
//    @Query(value = "SELECT p from Pitch p " +
//            "INNER JOIN  p.facility f " +
//            "INNER JOIN  f.city c  " +
//            "WHERE p.pitchType = :pitchType AND c.id = :cityId")
    Page<Pitch> findAllByCityIdAndPitchType(@Param("cityId") long cityId, @Param("pitchType") PitchType pitchType, Pageable pageable);
}
