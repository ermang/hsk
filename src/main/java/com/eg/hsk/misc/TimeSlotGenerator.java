package com.eg.hsk.misc;

import com.eg.hsk.dto.DailyTimeSlotDTO;
import com.eg.hsk.dto.TimeSlotDTO;
import com.eg.hsk.entity.Reservation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeSlotGenerator {

    private final int timeSlotsInDay = 24;

    public DailyTimeSlotDTO dailyTimeSlotDTO(long stadiumId) {
        TimeSlotDTO[] timeSlotDTOs = new TimeSlotDTO[timeSlotsInDay];
        for (int i = 0; i< timeSlotsInDay; i++)
            timeSlotDTOs[i] = new TimeSlotDTO(i, i+1, stadiumId, false);

        DailyTimeSlotDTO dailyTimeSlotDTO = new DailyTimeSlotDTO(timeSlotDTOs);

        return dailyTimeSlotDTO;
    }

    public DailyTimeSlotDTO updateWithReservations(DailyTimeSlotDTO dailyTimeSlotDTO,List<Reservation> reservations) {
        for (Reservation r : reservations)
            dailyTimeSlotDTO.timeSlotDTOs[r.getBeginHour().getHour()]= new TimeSlotDTO(r.getBeginHour().getHour(),
                    r.getEndHour().getHour(), r.getPitch().getId(), true);

        return dailyTimeSlotDTO;
    }
}
