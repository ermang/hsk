package com.eg.hsk.dto.in;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateReservationDto {

    public long pitchId;

    @NotNull(message = "reservationBegin can not be null")
    public LocalDateTime reservationBegin;

    @NotNull(message = "reservationEnd can not be null")
    public LocalDateTime reservationEnd;

}
