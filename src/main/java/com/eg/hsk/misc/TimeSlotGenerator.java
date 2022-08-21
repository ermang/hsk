package com.eg.hsk.misc;

import com.eg.hsk.dto.DailyTimeSlotDto;
import com.eg.hsk.dto.TimeSlotDto;
import org.springframework.stereotype.Component;

@Component
public class TimeSlotGenerator {

    private final int timeSlotsInDay = 24;

    public DailyTimeSlotDto dailyTimeSlotDTO(long stadiumId) {
        TimeSlotDto[] timeSlotDtos = new TimeSlotDto[timeSlotsInDay];
        for (int i = 0; i< timeSlotsInDay; i++)
            timeSlotDtos[i] = new TimeSlotDto(i, i+1, stadiumId, false);

        DailyTimeSlotDto dailyTimeSlotDTO = new DailyTimeSlotDto(timeSlotDtos);

        return dailyTimeSlotDTO;
    }

//    public DailyTimeSlotDTO updateWithReservations(DailyTimeSlotDTO dailyTimeSlotDTO,List<Reservation> reservations) {
//        for (Reservation r : reservations)
//            dailyTimeSlotDTO.timeSlotDTOs[r.getBeginHour().getHour()]= new TimeSlotDTO(r.getBeginHour().getHour(),
//                    r.getEndHour().getHour(), r.getPitch().getId(), true);
//
//        return dailyTimeSlotDTO;
//    }
}
