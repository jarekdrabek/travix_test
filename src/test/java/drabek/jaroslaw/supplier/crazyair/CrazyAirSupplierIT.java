package drabek.jaroslaw.supplier.crazyair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import drabek.jaroslaw.Application;
import drabek.jaroslaw.Flight;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class CrazyAirSupplierIT extends AbstractJUnit4SpringContextTests {

    private MockRestServiceServer mockServer;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CrazyAirSupplierSearch crazyAirSupplierSearch;

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void request_completely_specified_search() throws JsonProcessingException {
        //given
        mockServer.expect(requestTo("https://www.crazyflight.com/flights?returnDate=%222017-04-11%22&origin=KRK&destination=STD&numberOfPassengers=2&departureDate=%222017-04-04%22"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(objectMapper.writeValueAsString(
                        Lists.newArrayList(
                                new CrazyAirResponseDTO(
                                        "British Airways",
                                        "123.45",
                                        "E",
                                        "STD",
                                        "KRK",
                                        LocalDateTime.of(2017, 4, 12, 13, 15),
                                        LocalDateTime.of(2017, 4, 12, 14, 30)
                                ),
                                new CrazyAirResponseDTO(
                                        "British Airways",
                                        "500.00",
                                        "E",
                                        "FUE",
                                        "NYC",
                                        LocalDateTime.of(2017, 4, 12, 13, 15),
                                        LocalDateTime.of(2017, 4, 12, 17, 30)
                                )
                        )
                ), MediaType.APPLICATION_JSON));
        //when
        Stream<Flight> search = crazyAirSupplierSearch.search(lookingForFlight()
                .from("KRK")
                .to("STD")
                .on(LocalDate.of(2017,4,4))
                .back(LocalDate.of(2017,4,11))
                .count(2)
                .create());

        List<Flight> list = search.collect(Collectors.toList());
        System.out.println("");
    }
}