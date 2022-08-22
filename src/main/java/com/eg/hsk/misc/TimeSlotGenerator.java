package com.eg.hsk.misc;

import com.eg.hsk.dto.DailyTimeSlotDto;
import com.eg.hsk.dto.TimeSlotDto;
import com.eg.hsk.entity.Reservation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.eg.hsk.misc.Constant.MIN_RESERVATION_DURATION_IN_MINUTES;

@Component
public class TimeSlotGenerator {

    private final int timeSlotsInDay = Constant.DAY_AS_MINUTES / Constant.MIN_RESERVATION_DURATION_IN_MINUTES;



    public DailyTimeSlotDto generateDailyTimeSlotDTO(long pitchId, LocalDate localDate, List<Reservation> reservationList) {

        TimeSlotDto[] timeSlotDtoList = new TimeSlotDto[timeSlotsInDay];

        LocalDateTime tempDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0));
        for (int i = 0; i < timeSlotsInDay; i++) {

            LocalDateTime endDateTime = tempDateTime.plusMinutes(Constant.MIN_RESERVATION_DURATION_IN_MINUTES);
            timeSlotDtoList[i] = new TimeSlotDto(pitchId, tempDateTime, endDateTime, false);

            tempDateTime = LocalDateTime.from(tempDateTime).plusMinutes(Constant.MIN_RESERVATION_DURATION_IN_MINUTES);
        }

        DailyTimeSlotDto dailyTimeSlotDTO = new DailyTimeSlotDto(timeSlotDtoList);

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
