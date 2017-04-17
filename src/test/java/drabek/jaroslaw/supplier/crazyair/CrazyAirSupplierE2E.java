package drabek.jaroslaw.supplier.crazyair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import drabek.jaroslaw.Flight;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static drabek.jaroslaw.FlightBuilder.flight;
import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test.properties")
public class CrazyAirSupplierE2E extends AbstractJUnit4SpringContextTests {

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
    public void request_complete_search_test() throws JsonProcessingException {
        //given
        mockServer.expect(requestTo("https://www.crazyflight-test.com/flights?returnDate=2017-04-06&origin=KRK&destination=STD&numberOfPassengers=1&departureDate=2017-04-04"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(objectMapper.writeValueAsString(
                        Lists.newArrayList(
                                new CrazyAirResponseDTO(
                                        "British Airways",
                                        "123.45",
                                        "E",
                                        "KRK",
                                        "STD",
                                        LocalDateTime.of(2017, 4, 4, 13, 15),
                                        LocalDateTime.of(2017, 4, 6, 14, 30)
                                ),
                                new CrazyAirResponseDTO(
                                        "British Airways",
                                        "500.00",
                                        "E",
                                        "KRK",
                                        "STD",
                                        LocalDateTime.of(2017, 4, 4, 9, 15),
                                        LocalDateTime.of(2017, 4, 6, 10, 30)
                                )
                        )
                ), MediaType.APPLICATION_JSON));
        //when
        List<Flight> results = crazyAirSupplierSearch.search(
                lookingForFlight()
                        .from("KRK")
                        .to("STD")
                        .on(LocalDate.of(2017, 4, 4))
                        .back(LocalDate.of(2017, 4, 6))
                        .count(1)
                        .create()
        ).collect(Collectors.toList());
        //then
        Assertions.assertThat(results).containsExactlyInAnyOrder(
                flight()
                        .from("KRK").to("STD")
                        .forFare(new BigDecimal("500.00"))
                        .leavingAt(LocalDateTime.of(2017, 4, 4, 9, 15))
                        .arrivalAt(LocalDateTime.of(2017, 4, 6, 10, 30))
                        .withAirline("British Airways")
                        .withSupplier("Crazy Air")
                        .create(),
                flight()
                        .from("KRK").to("STD")
                        .forFare(new BigDecimal("123.45"))
                        .leavingAt(LocalDateTime.of(2017, 4, 4, 13, 15))
                        .arrivalAt(LocalDateTime.of(2017, 4, 6, 14, 30))
                        .withAirline("British Airways")
                        .withSupplier("Crazy Air")
                        .create()
        );
    }

    @Test
    public void request_partial_search_test() throws JsonProcessingException {
        //given
        mockServer.expect(requestTo("https://www.crazyflight-test.com/flights?origin=KRK&numberOfPassengers=1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(objectMapper.writeValueAsString(
                        Lists.newArrayList(
                                new CrazyAirResponseDTO(
                                        "British Airways",
                                        "123.45",
                                        "E",
                                        "KRK",
                                        "STD",
                                        LocalDateTime.of(2017, 4, 7, 13, 15),
                                        LocalDateTime.of(2017, 4, 21, 14, 30)
                                ),
                                new CrazyAirResponseDTO(
                                        "PL LOT",
                                        "500.00",
                                        "E",
                                        "KRK",
                                        "NYC",
                                        LocalDateTime.of(2017, 4, 4, 9, 15),
                                        LocalDateTime.of(2017, 5, 6, 10, 30)
                                )
                        )
                ), MediaType.APPLICATION_JSON));
        //when
        List<Flight> results = crazyAirSupplierSearch.search(
                lookingForFlight()
                        .from("KRK")
                        .count(1)
                        .create()
        ).collect(Collectors.toList());
        //then
        Assertions.assertThat(results).containsExactlyInAnyOrder(
                flight()
                        .from("KRK").to("NYC")
                        .forFare(new BigDecimal("500.00"))
                        .leavingAt(LocalDateTime.of(2017, 4, 4, 9, 15))
                        .arrivalAt(LocalDateTime.of(2017, 5, 6, 10, 30))
                        .withAirline("PL LOT")
                        .withSupplier("Crazy Air")
                        .create(),
                flight()
                        .from("KRK").to("STD")
                        .forFare(new BigDecimal("123.45"))
                        .leavingAt(LocalDateTime.of(2017, 4, 7, 13, 15))
                        .arrivalAt(LocalDateTime.of(2017, 4, 21, 14, 30))
                        .withAirline("British Airways")
                        .withSupplier("Crazy Air")
                        .create()
        );
    }


}