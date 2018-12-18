package egcom.hsk.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateReservationDTO {
    public long stadiumId;
    public LocalDate reservationDate;
    public LocalTime beginHour;
    public LocalTime endHour;
}
