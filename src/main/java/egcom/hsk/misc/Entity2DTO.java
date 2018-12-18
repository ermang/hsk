package egcom.hsk.misc;

import egcom.hsk.dto.TimeSlotDTO;
import egcom.hsk.entity.Reservation;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Entity2DTO {

    public List<TimeSlotDTO> createTimeSlots(long stadiumId, List<Reservation> reservations) {
        List<TimeSlotDTO> timeSlotDTOs = new ArrayList<>();
        for (int i = 0;i<24;i++)
            timeSlotDTOs.add(new TimeSlotDTO(i, i+1, stadiumId, false));

        for (Reservation r : reservations)
            timeSlotDTOs.set(r.getBeginHour().getHour(), new TimeSlotDTO(r.getBeginHour().getHour(), r.getEndHour().getHour(), stadiumId, true));

        return timeSlotDTOs;
    }
}
