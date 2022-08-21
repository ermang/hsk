package com.eg.hsk.misc;

import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.dto.in.CreatePitchDto;
import com.eg.hsk.entity.Facility;
import com.eg.hsk.entity.Pitch;
import com.eg.hsk.repo.FacilityRepo;
import com.eg.hsk.repo.PitchRepo;
import org.springframework.stereotype.Component;

@Component
public class Dto2Entity {

    private final FacilityRepo facilityRepo;
    private final PitchRepo pitchRepo;

    public Dto2Entity(FacilityRepo facilityRepo, PitchRepo pitchRepo) {
        this.facilityRepo = facilityRepo;
        this.pitchRepo = pitchRepo;
    }

    public Facility createFacilityDto2Facility(CreateFacilityDto dto) {
        Facility f = new Facility();
        f.setName(dto.name);

        return f;
    }

    public Pitch createPitchDto2Pitch(CreatePitchDto dto) {
        Pitch p = new Pitch();
        p.setPitchType(dto.pitchType);
        Facility f = facilityRepo.findById(dto.facilityId).get();
        p.setFacility(f);

        return p;
    }

}
