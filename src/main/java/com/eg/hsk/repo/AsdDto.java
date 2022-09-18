package com.eg.hsk.repo;

public class AsdDto {
    public long pitchId;
    public long facilityId;
    public String facilityName;
    public long cityId;
    public String cityName;

    public AsdDto(long pitchId, long facilityId, String facilityName, long cityId, String cityName) {
        this.pitchId = pitchId;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.cityId = cityId;
        this.cityName = cityName;
    }
}
