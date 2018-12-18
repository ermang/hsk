package egcom.hsk.dto;

public class TimeSlotDTO {
    public final int beginHour;
    public final int endHour;
    public final long stadiumId;
    public final boolean reserved;

    public TimeSlotDTO(int beginHour, int endHour, long stadiumId, boolean reserved) {
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.stadiumId = stadiumId;
        this.reserved = reserved;
    }
}
