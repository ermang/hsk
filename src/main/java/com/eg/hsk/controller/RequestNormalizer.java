package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.in.CreateFacilityDto;
import org.springframework.stereotype.Component;

@Component
public class RequestNormalizer {

    public void normalize(CreateCityDto dto) {
        dto.name = dto.name.toUpperCase();
    }

    public void normalize(CreateFacilityDto dto) {
        dto.name = dto.name.toUpperCase();
    }
}
