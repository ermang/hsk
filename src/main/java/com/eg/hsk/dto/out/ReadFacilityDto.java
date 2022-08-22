package com.eg.hsk.dto.out;

public class ReadFacilityDto {
    public final long id;
    public final String name;
    public final ReadCityDto readCityDto;

    public ReadFacilityDto(long id, String name, ReadCityDto readCityDto) {
        this.id = id;
        this.name = name;
        this.readCityDto = readCityDto;
    }
}
