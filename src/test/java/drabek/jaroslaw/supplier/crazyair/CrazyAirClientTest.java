package drabek.jaroslaw.supplier.crazyair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import drabek.jaroslaw.Flight;
import drabek.jaroslaw.FlightBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static drabek.jaroslaw.FlightBuilder.flight;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class CrazyAirClientTest {

    private RestTemplate restTemplate = new RestTemplate();
    private MockRestServiceServer mockServer;
    ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void request_test() throws JsonProcessingException {
        //given
        mockServer.expect(requestTo("https://www.crazyflight.com/flights"))
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
        List<CrazyAirResponseDTO> flights = new CrazyAirClient(restTemplate).getFlights(null);
    }
}