package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.service.FacilityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final FacilityService facilityService;

    public MainController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping(path = "/facility")
    public void createFacility(@RequestBody CreateFacilityDto createFacilityDto) {
        facilityService.createFacility(createFacilityDto);
    }

    @PostMapping(path = "/pitch")
    public void createPitch(@RequestBody CreatePitchDto createPitchDto) {
        facilityService.createPitch(createPitchDto);
    }
}
