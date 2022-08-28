package com.eg.hsk.service;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.entity.City;
import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.repo.CityRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CityService {

    private final Dto2Entity dto2Entity;
    private final CityRepo cityRepo;

    public CityService(Dto2Entity dto2Entity, CityRepo cityRepo) {
        this.dto2Entity = dto2Entity;
        this.cityRepo = cityRepo;
    }


    public void createCity(CreateCityDto createCityDto) {
        City city = dto2Entity.createCityDto2City(createCityDto);

        cityRepo.save(city);
    }
}
