package drabek.jaroslaw.supplier.crazyair;

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
public class CrazyAirClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${crazy.air.url}")
    private String crazyAirURL;

    @ExternalService
    public List<CrazyAirResponseDTO> getFlights(MultiValueMap<String,String> requestParameters) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(crazyAirURL +"/flights")
                .queryParams(requestParameters)
                .build().encode().toUri();

        return Arrays.asList(restTemplate.getForObject(uri, CrazyAirResponseDTO[].class));
    }

}
