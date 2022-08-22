package com.eg.hsk.dto.out;

import com.eg.hsk.entity.PitchType;

public class ReadPitchDto {
    public final long id;
    public final PitchType pitchType;
    public final ReadFacilityDto readFacilityDto;

    public ReadPitchDto(long id, PitchType pitchType, ReadFacilityDto readFacilityDto) {
        this.id = id;
        this.pitchType = pitchType;
        this.readFacilityDto = readFacilityDto;
    }
}
