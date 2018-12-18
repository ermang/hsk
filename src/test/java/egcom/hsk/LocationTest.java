package egcom.hsk;

import egcom.hsk.dto.CreateReservationDTO;
import egcom.hsk.dto.CreateStadiumDTO;
import egcom.hsk.entity.Stadium;
import egcom.hsk.service.MainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

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
}
