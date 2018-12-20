package egcom.hsk;

import egcom.hsk.dto.*;
import egcom.hsk.entity.Reservation;
import egcom.hsk.service.MainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RunWith(SpringRunner.class)
//@WithMockUser   //DefaultUser with username "user", password "password", and a single GrantedAuthority named "ROLE_USER"
@DataJpaTest(includeFilters = @ComponentScan.Filter(classes = {Service.class, Component.class}))
public class LocationTest {
    private final TestFactory testFactory;

    @Autowired
    private MainService service;

    public LocationTest() {
        this.testFactory = new TestFactory();
    }

    @Test
    public void create_stadium() {
        CreateStadiumDTO createStadiumDTO = testFactory.createStadiumDTO();
        Long actual = service.createStadium(createStadiumDTO);

        Assert.assertNotNull(actual);
    }

    @Test
    public void create_stadium_create_reservation() {
        CreateStadiumDTO createStadiumDTO = testFactory.createStadiumDTO();
        Long stadiumId = service.createStadium(createStadiumDTO);

        CreateReservationDTO createReservationDTO = testFactory.createReservationDTO();
        Long actual = service.createReservation(createReservationDTO);

        Assert.assertNotNull(actual);
    }

    @Test
    public void list_stadiums_in_city() {
        CreateStadiumDTO dto = testFactory.createStadiumDTO();
        service.createStadium(dto);
        CreateStadiumDTO dto2 = testFactory.createStadiumDTO();
        dto2.city = "ankara";
        service.createStadium(dto2);

        List<StadiumDTO> actual = service.readStadiumsByCity("ankara");
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals("ankara", actual.get(0).city);
    }

    @Test
    public void list_stadiums_in_city_and_district() {
        CreateStadiumDTO dto = testFactory.createStadiumDTO();
        service.createStadium(dto);

        List<StadiumDTO> actual = service.readStadiumsByCityAndDistrict("istanbul", "maltepe");
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals("istanbul", actual.get(0).city);
        Assert.assertEquals("maltepe", actual.get(0).district);
    }

    @Test
    public void list_reservations_for_stadium_on_date() {
        CreateStadiumDTO createStadiumDTO = testFactory.createStadiumDTO();
        Long stadiumId = service.createStadium(createStadiumDTO);

        CreateReservationDTO reservationDTO = testFactory.createReservationDTO();
        reservationDTO.stadiumId = stadiumId;
        service.createReservation(reservationDTO);

        List<Reservation> reservations = service.readReservations(stadiumId, LocalDate.now());

        Assert.assertEquals(1, reservations.size());
    }

    @Test
    public void list_time_slots_for_stadium_on_date() {
        CreateStadiumDTO createStadiumDTO = testFactory.createStadiumDTO();
        Long stadiumId = service.createStadium(createStadiumDTO);

        CreateReservationDTO reservationDTO = testFactory.createReservationDTO();
        reservationDTO.stadiumId = stadiumId;
        service.createReservation(reservationDTO);

        DailyTimeSlotDTO dailyTimeSlotDTO = service.readTimeSlots(stadiumId, LocalDate.now());

        Assert.assertEquals(true, dailyTimeSlotDTO.timeSlotDTOs[LocalTime.now().getHour()].reserved);
    }
}
