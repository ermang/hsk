package com.eg.hsk.dto.out;

import java.util.List;

public class ReadCityListDto {
    public final List<ReadCityDto> readCityDtoList;

    public ReadCityListDto(List<ReadCityDto> readCityDtoList) {
        this.readCityDtoList = readCityDtoList;
    }
}
