package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.common.ExternalSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.stream.Stream;

@Service
public class CrazyAirClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${crazy.air.url}")
    private String crazyAirURL;

    @ExternalSupplier
    public Stream<CrazyAirResponseDTO> getFlights(MultiValueMap<String,String> requestParameters) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(crazyAirURL +"/flights")
                .queryParams(requestParameters)
                .build().encode().toUri();

        return Stream.of(restTemplate.getForObject(uri, CrazyAirResponseDTO[].class));
    }

}
