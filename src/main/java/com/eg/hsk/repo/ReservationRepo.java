package com.eg.hsk.repo;

import com.eg.hsk.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.pitch.id = :pitchId AND r.reservationBegin > :beginDateTime AND r.reservationEnd < :endDateTime")
    List<Reservation> findAllByDateAndPitchId(@Param("beginDateTime") LocalDateTime beginDateTime, @Param("endDateTime") LocalDateTime endDateTime,
                                              @Param("pitchId") long pitchId);
}
