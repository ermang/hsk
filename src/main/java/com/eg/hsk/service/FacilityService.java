package com.eg.hsk.service;

import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.entity.Facility;
import com.eg.hsk.entity.Pitch;
import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.repo.FacilityRepo;
import com.eg.hsk.repo.PitchRepo;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {

    private final Dto2Entity dto2Entity;
    private final FacilityRepo facilityRepo;
    private final PitchRepo pitchRepo;

    public FacilityService(Dto2Entity dto2Entity, FacilityRepo facilityRepo, PitchRepo pitchRepo) {
        this.dto2Entity = dto2Entity;
        this.facilityRepo = facilityRepo;
        this.pitchRepo = pitchRepo;
    }

    public void createFacility(CreateFacilityDto createFacilityDto) {
        Facility facility = dto2Entity.createFacilityDto2Facility(createFacilityDto);

        facilityRepo.save(facility);
    }

    public void createPitch(CreatePitchDto createPitchDto) {
        Pitch pitch = dto2Entity.createPitchDto2Pitch(createPitchDto);

        pitchRepo.save(pitch);
    }
}
