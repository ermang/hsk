package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.service.FacilityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(path = "/city")
@RestController
public class CityController {

    private final RequestNormalizer requestNormalizer;
    private final FacilityService facilityService;

    public CityController(RequestNormalizer requestNormalizer, FacilityService facilityService) {
        this.requestNormalizer = requestNormalizer;
        this.facilityService = facilityService;
    }

    @PostMapping
    public void createCity(@Valid @RequestBody CreateCityDto createCityDto) {
        requestNormalizer.normalize(createCityDto);
        facilityService.createCity(createCityDto);
    }
}
