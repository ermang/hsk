package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.dto.out.ReadPitchDto;
import com.eg.hsk.entity.PitchType;
import com.eg.hsk.service.FacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/pitch")
@RestController
public class PitchController {

    private final FacilityService facilityService;

    public PitchController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }


    @PostMapping
    public void createPitch(@RequestBody CreatePitchDto createPitchDto) {
        facilityService.createPitch(createPitchDto);
    }

    @GetMapping(path = "/city/{cityId}")
    public Page<ReadPitchDto> searchPitch(@PathVariable long cityId, @RequestParam PitchType pitchType, Pageable pageable) {

        return facilityService.searchPitch(cityId, pitchType, pageable);
    }
}
