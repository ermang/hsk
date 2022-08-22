package com.eg.hsk.misc;

import com.eg.hsk.dto.out.ReadCityDto;
import com.eg.hsk.dto.out.ReadFacilityDto;
import com.eg.hsk.dto.out.ReadPitchDto;
import com.eg.hsk.entity.City;
import com.eg.hsk.entity.Facility;
import com.eg.hsk.entity.Pitch;
import org.springframework.stereotype.Component;

@Component
public class Entity2Dto {

    public ReadCityDto city2ReadCityDto(City c) {
        ReadCityDto rcd = new ReadCityDto(c.getId(), c.getName());

        return rcd;
    }

    public ReadFacilityDto facility2ReadFacilityDto(Facility f) {
        ReadFacilityDto rfd = new ReadFacilityDto(f.getId(), f.getName(), city2ReadCityDto(f.getCity()));

        return rfd;
    }

    public ReadPitchDto pitch2ReadPitchDto(Pitch pitch) {
        ReadPitchDto rpd = new ReadPitchDto(pitch.getId(), pitch.getPitchType(), facility2ReadFacilityDto(pitch.getFacility()));

        return rpd;
    }

}
