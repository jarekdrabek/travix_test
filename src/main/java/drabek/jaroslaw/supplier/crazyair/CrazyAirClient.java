package drabek.jaroslaw.supplier.crazyair;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class CrazyAirClient {

    private RestTemplate restTemplate = new RestTemplate();

    public CrazyAirClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CrazyAirResponseDTO> getFlights(MultiValueMap<String,String> parameters) {
        String uri = UriComponentsBuilder
                .fromHttpUrl("https://www.crazyflight.com/flights")
                .queryParams(parameters)
                .toUriString();

        return asList(restTemplate.getForObject(uri, CrazyAirResponseDTO[].class));
    }


    public static void main(String[] args) {
        String uri = UriComponentsBuilder.fromHttpUrl("https://www.crazyflight.com/flights")
                .queryParam("origin", Optional.empty())
                .queryParam("destination", Optional.of("WAR")).toUriString();

        System.out.println(uri);
    }

}
