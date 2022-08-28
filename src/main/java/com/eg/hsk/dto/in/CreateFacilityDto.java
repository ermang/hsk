package com.eg.hsk.dto.in;

import javax.validation.constraints.NotBlank;

public class CreateFacilityDto {

    @NotBlank(message = "name can not be blank")
    public String name;
    public long cityId;
}
