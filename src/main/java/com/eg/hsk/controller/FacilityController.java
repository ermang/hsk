package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.service.FacilityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(path = "/facility")
@RestController
public class FacilityController {

    private final RequestNormalizer requestNormalizer;
    private final FacilityService facilityService;

    public FacilityController(RequestNormalizer requestNormalizer, FacilityService facilityService) {
        this.requestNormalizer = requestNormalizer;
        this.facilityService = facilityService;
    }


    @PostMapping
    public void createFacility(@Valid @RequestBody CreateFacilityDto createFacilityDto) {
        requestNormalizer.normalize(createFacilityDto);
        facilityService.createFacility(createFacilityDto);
    }
}
