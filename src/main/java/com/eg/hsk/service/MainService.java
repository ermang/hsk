package com.eg.hsk.service;

import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.misc.Entity2Dto;
import com.eg.hsk.misc.TimeSlotGenerator;
import com.eg.hsk.repo.ReservationRepo;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final Dto2Entity dto2Entity;
    private final Entity2Dto entity2DTO;
    private final TimeSlotGenerator timeSlotGenerator;

    private final ReservationRepo reservationRepo;


    public MainService(Dto2Entity dto2Entity, Entity2Dto entity2DTO, TimeSlotGenerator timeSlotGenerator,
                       ReservationRepo reservationRepo) {
        this.dto2Entity = dto2Entity;
        this.entity2DTO = entity2DTO;
        this.timeSlotGenerator = timeSlotGenerator;
        this.reservationRepo = reservationRepo;
    }

}
