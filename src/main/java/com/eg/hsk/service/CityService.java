package com.eg.hsk.service;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.out.ReadCityDto;
import com.eg.hsk.dto.out.ReadCityListDto;
import com.eg.hsk.entity.City;
import com.eg.hsk.misc.Dto2Entity;
import com.eg.hsk.misc.Entity2Dto;
import com.eg.hsk.repo.CityRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CityService {

    private final Dto2Entity dto2Entity;
    private final Entity2Dto entity2Dto;
    private final CityRepo cityRepo;

    public CityService(Dto2Entity dto2Entity, Entity2Dto entity2Dto, CityRepo cityRepo) {
        this.dto2Entity = dto2Entity;
        this.entity2Dto = entity2Dto;
        this.cityRepo = cityRepo;
    }


    public void createCity(CreateCityDto createCityDto) {
        City city = dto2Entity.createCityDto2City(createCityDto);

        cityRepo.save(city);
    }

    public ReadCityListDto readCityList() {
        List<City> cityList = cityRepo.findAllByOrderByNameAsc();

        List<ReadCityDto> readCityDtoList = new ArrayList<>();
        for(City c : cityList) {
            readCityDtoList.add(entity2Dto.city2ReadCityDto(c));
        }

        ReadCityListDto readCityListDto = new ReadCityListDto(readCityDtoList);

        return readCityListDto;
    }
}
