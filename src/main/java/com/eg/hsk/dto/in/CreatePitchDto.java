package com.eg.hsk.dto.in;

import com.eg.hsk.entity.PitchType;

import javax.validation.constraints.NotNull;

public class CreatePitchDto {

    @NotNull(message = "pitchType can not be blank")
    public PitchType pitchType;
    public long facilityId;
}
