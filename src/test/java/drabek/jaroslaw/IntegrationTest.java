package drabek.jaroslaw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import drabek.jaroslaw.supplier.crazyair.CrazyAirResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class IntegrationTest extends AbstractJUnit4SpringContextTests {

    private MockRestServiceServer mockServer;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void should_return_results_from_crazy_air_supplier() throws Exception {
        //given
        mockServer.expect(requestTo("https://www.crazyflight.com/flights?returnDate=%222017-04-06%22&origin=KRK&destination=STD&numberOfPassengers=1"))
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
        mvc.perform(get("/v1/flight?origin=KRK&destination=STD&returnDate=2017-04-06")
                .accept(MediaType.APPLICATION_JSON))
                //then
                .andExpect(content().string(equalTo(
                        "[" +
                                "{" +
                                    "\"airline\":\"British Airways\"," +
                                    "\"supplier\":\"Crazy Air\"," +
                                    "\"fare\":123.45," +
                                    "\"departureAirport\":\"KRK\"," +
                                    "\"destinationAirport\":\"STD\"," +
                                    "\"departureDate\":\"2017-04-04T13:15:00\"," +
                                    "\"arrivalDate\":\"2017-04-06T14:30:00\"" +
                                "},{" +
                                    "\"airline\":\"British Airways\"," +
                                    "\"supplier\":\"Crazy Air\"," +
                                    "\"fare\":500.00," +
                                    "\"departureAirport\":\"KRK\"," +
                                    "\"destinationAirport\":\"STD\"," +
                                    "\"departureDate\":\"2017-04-04T09:15:00\"," +
                                    "\"arrivalDate\":\"2017-04-06T10:30:00\"" +
                                "}" +
                        "]")));

    }
}
