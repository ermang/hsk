package com.eg.hsk.dto.in;

import javax.validation.constraints.NotBlank;

public class CreateCityDto {

    @NotBlank(message = "name can not be blank")
    public String name;
}
