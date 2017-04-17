package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.supplier.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class ToughJetClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${taugh.jet.url}")
    private String taughJetURL;

    @ExternalService
    public List<TaughJetResponseDTO> getFlights(MultiValueMap<String,String> requestParameters) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(taughJetURL +"/flights")
                .queryParams(requestParameters)
                .build().encode().toUri();

        return Arrays.asList(restTemplate.getForObject(uri, TaughJetResponseDTO[].class));
    }


}
