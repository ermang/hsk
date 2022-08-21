package com.eg.hsk.dto;

public class DailyTimeSlotDto {
    public final TimeSlotDto[] timeSlotDtoList;

    public DailyTimeSlotDto(TimeSlotDto[] timeSlotDtoList) {
        this.timeSlotDtoList = timeSlotDtoList;
    }
}
