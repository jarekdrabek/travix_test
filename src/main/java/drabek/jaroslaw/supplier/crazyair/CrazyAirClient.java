package drabek.jaroslaw.supplier.crazyair;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class CrazyAirClient {

    private RestTemplate restTemplate = new RestTemplate();

    public CrazyAirClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CrazyAirResponseDTO> getFlights(CrazyAirRequestDTO crazyAirRequestDTO) {
        return asList(restTemplate.getForObject("https://www.crazyflight.com/flights", CrazyAirResponseDTO[].class));
    }
}
