package com.eg.hsk.dto;

import java.time.LocalDateTime;

public class TimeSlotDto {

    public final long pitchId;
    public final LocalDateTime slotBegin;
    public final LocalDateTime slotEnd;
    public final boolean reserved;

    public TimeSlotDto(long pitchId, LocalDateTime slotBegin, LocalDateTime slotEnd, boolean reserved) {
        this.slotBegin = slotBegin;
        this.slotEnd = slotEnd;
        this.pitchId = pitchId;
        this.reserved = reserved;
    }
}
