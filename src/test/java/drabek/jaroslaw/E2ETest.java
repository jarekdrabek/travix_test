package drabek.jaroslaw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import drabek.jaroslaw.supplier.crazyair.CrazyAirResponseDTO;
import drabek.jaroslaw.supplier.toughjet.ToughJetResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
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
@TestPropertySource("classpath:test.properties")
public class E2ETest extends AbstractJUnit4SpringContextTests {

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
    public void should_return_results_from_crazy_air_supplier_and_tough_jet_supplier() throws Exception {
        //given
        mockServer.expect(requestTo("https://www.crazyflight-test.com/flights?returnDate=2017-04-06&origin=KRK&destination=STD&numberOfPassengers=1"))
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
        mockServer.expect(requestTo("https://www.taughjet-test.com/flights?numberOfAdults=1&returnMonth=4&from=KRK&to=STD&returnYear=2017&returnDay=6"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(objectMapper.writeValueAsString(
                        Lists.newArrayList(
                                new ToughJetResponseDTO(
                                        "British Airways",
                                        "200",
                                        "100",
                                        "20",
                                        "KRK",
                                        "STD",
                                        12,
                                        4,
                                        2017,
                                        13,
                                        5,
                                        2017
                                ),
                                new ToughJetResponseDTO(
                                        "British Airways",
                                        "123.45",
                                        "56.00",
                                        "60",
                                        "KRK",
                                        "STD",
                                        12,
                                        4,
                                        2017,
                                        1,
                                        12,
                                        2017
                                )                        )
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
                                "},{" +
                                    "\"airline\":\"British Airways\"," +
                                    "\"supplier\":\"Tough Jet\"," +
                                    "\"fare\":240," +
                                    "\"departureAirport\":\"KRK\"," +
                                    "\"destinationAirport\":\"STD\"," +
                                    "\"departureDate\":\"2017-04-12T12:00:00\"," +
                                    "\"arrivalDate\":\"2017-05-13T12:00:00\"" +
                                "},{" +
                                    "\"airline\":\"British Airways\"," +
                                    "\"supplier\":\"Tough Jet\"," +
                                    "\"fare\":71.78," +
                                    "\"departureAirport\":\"KRK\"," +
                                    "\"destinationAirport\":\"STD\"," +
                                    "\"departureDate\":\"2017-04-12T12:00:00\"," +
                                    "\"arrivalDate\":\"2017-12-01T12:00:00\"" +
                                "}"+
                        "]")));

    }
}
