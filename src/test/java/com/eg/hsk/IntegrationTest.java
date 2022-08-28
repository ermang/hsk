package com.eg.hsk;

import com.eg.hsk.dto.in.CreateCityDto;
import com.eg.hsk.dto.in.CreateFacilityDto;
import com.eg.hsk.service.CityService;
import com.eg.hsk.service.FacilityService;
import com.eg.hsk.service.MainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@WithMockUser   //DefaultUser with username "user", password "password", and a single GrantedAuthority named "ROLE_USER"
@DataJpaTest(includeFilters = @ComponentScan.Filter(classes = {Service.class, Component.class}))
public class IntegrationTest {


    @Autowired
    private MainService service;
    @Autowired
    private CityService cityService;
    @Autowired
    private FacilityService facilityService;

    public IntegrationTest() {
    }

    @Test(expected = Test.None.class)
    public void create_city() {
        CreateCityDto dto = new CreateCityDto();
        dto.name = "ISTANBUL";

        cityService.createCity(dto);
    }

    @Test
    public void create_city_throws_error_on_unique_constraint_on_name_field() {
        CreateCityDto dto = new CreateCityDto();
        dto.name = "ISTANBUL";

        cityService.createCity(dto);

        Exception actual = null;

        try {
            cityService.createCity(dto);
        } catch (Exception e) {
            actual = e;
        }

        Assert.assertEquals(DataIntegrityViolationException.class, actual.getClass());
    }

    @Test(expected = Test.None.class)
    public void create_facility() {
        CreateCityDto createCityDto = new CreateCityDto();
        createCityDto.name = "ISTANBUL";

        cityService.createCity(createCityDto);

        CreateFacilityDto dto = new CreateFacilityDto();
        dto.name = "OSMAN SPOR TESISLERI";
        dto.cityId = 1L;

        facilityService.createFacility(dto);
    }

    @Test
    public void create_facility_throws_error_on_unique_constraint_on_name_field() {
        CreateCityDto createCityDto = new CreateCityDto();
        createCityDto.name = "ISTANBUL";

        cityService.createCity(createCityDto);

        CreateFacilityDto dto = new CreateFacilityDto();
        dto.name = "OSMAN SPOR TESISLERI";
        dto.cityId = 1L;

        facilityService.createFacility(dto);

        Exception actual = null;

        try {
            facilityService.createFacility(dto);
        } catch (Exception e) {
            actual = e;
        }

        Assert.assertEquals(DataIntegrityViolationException.class, actual.getClass());
    }


}
