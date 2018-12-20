package egcom.hsk.dto;

public class DailyTimeSlotDTO {
    public final TimeSlotDTO[] timeSlotDTOs;

    public DailyTimeSlotDTO(TimeSlotDTO[] timeSlotDTOs) {
        this.timeSlotDTOs = timeSlotDTOs;
    }
}
