package com.eg.hsk.controller;

import com.eg.hsk.service.FacilityService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final FacilityService facilityService;

    public MainController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }






}
