package drabek.jaroslaw;

import drabek.jaroslaw.supplier.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static drabek.jaroslaw.FlightBuilder.flight;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class BusyFlightControllerTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private BusyFlightService busyFlightService;

    @InjectMocks
    @Autowired
    private BusyFlightController busyFlightController;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_endpoint() throws Exception {
        //given
        doReturn(
                Stream.of(flight()
                        .from("KRK").to("NYC")
                        .leavingAt(LocalDateTime.of(2017, 04, 7, 12, 30))
                        .arrivalAt(LocalDateTime.of(2017, 04, 14, 12, 30))
                        .create())
        ).when(busyFlightService).search(any());
        //when&then
        mvc.perform(get("/v1/flight?origin=KRK&destination=STD&returnDate=2017-04-06").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(
                        "[{" +
                                "\"airline\":\"Testing Airways\"," +
                                "\"supplier\":\"Testing-Supplier\"," +
                                "\"fare\":123.45," +
                                "\"departureAirport\":\"KRK\"," +
                                "\"destinationAirport\":\"NYC\"," +
                                "\"departureDate\":\"2017-04-07T12:30:00\"," +
                                "\"arrivalDate\":\"2017-04-14T12:30:00\"}]")));
        Mockito.verify(busyFlightService).search(SearchCriteriaBuilder.lookingForFlight().from("KRK").to("STD").back(LocalDate.of(2017, 4, 6)).create());
    }

    @Test
    public void should_return_500_with_message_if_internal_error() throws Exception {
        //given
        doThrow(new IllegalStateException("Internal error")
        ).when(busyFlightService).search(any());
        //when&then
        mvc.perform(get("/v1/flight?origin=KRK&destination=STD&returnDate=2017-04-06").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(equalTo("Sorry for inconvenience. We have temporary internal problems. Please, try again later")));
    }

}