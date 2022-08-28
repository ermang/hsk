package com.eg.hsk.dto.in;

import com.eg.hsk.entity.PitchType;

import javax.validation.constraints.NotBlank;

public class CreatePitchDto {

    @NotBlank(message = "pitchType can not be blank")
    public PitchType pitchType;
    public long facilityId;
}
