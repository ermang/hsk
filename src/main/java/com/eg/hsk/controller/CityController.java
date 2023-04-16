package com.eg.hsk.controller;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.out.ReadCityListDto;
import com.eg.hsk.service.CityService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/city")
@RestController
public class CityController {

    private final RequestNormalizer requestNormalizer;
    private final CityService cityService;

    public CityController(RequestNormalizer requestNormalizer, CityService cityService) {
        this.requestNormalizer = requestNormalizer;
        this.cityService = cityService;
    }

    @PostMapping
    public void createCity(@Valid @RequestBody CreateCityDto createCityDto) {
        requestNormalizer.normalize(createCityDto);
        cityService.createCity(createCityDto);
    }

    @GetMapping(path = "/cities")
    public ReadCityListDto readCities() {
        ReadCityListDto readCityListDto = cityService.readCityList();

        return readCityListDto;
    }

}
