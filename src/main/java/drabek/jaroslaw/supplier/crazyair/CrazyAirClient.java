package drabek.jaroslaw.supplier.crazyair;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.stream.Stream;

@Service
public class CrazyAirClient {

    private RestTemplate restTemplate = new RestTemplate();

    public CrazyAirClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Stream<CrazyAirResponseDTO> getFlights(MultiValueMap<String,String> requestParameters) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl("https://www.crazyflight.com/flights")
                .queryParams(requestParameters)
                .build().encode().toUri();

        return Stream.of(restTemplate.getForObject(uri, CrazyAirResponseDTO[].class));
    }

}
