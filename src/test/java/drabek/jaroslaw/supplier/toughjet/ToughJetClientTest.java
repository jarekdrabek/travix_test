package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.supplier.SupplierErrorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test.properties")
public class ToughJetClientTest {

    private MockRestServiceServer mockServer;

    @Autowired
    private SearchCriteria2TaughJetRequest searchCriteriaConverter;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ToughJetClient toughJetClient;

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test(expected = SupplierErrorException.class)
    public void should_throw_internal_supplier_exception_when_server_error(){
        //given
        mockServer.expect(requestTo("https://www.taughjet-test.com/flights?numberOfAdults=1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withServerError());
        //when&then
        List<TaughJetResponseDTO> flights = toughJetClient.getFlights(searchCriteriaConverter.toMap(lookingForFlight().create()));
    }


}