package drabek.jaroslaw.supplier.crazyair;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CrazyAirClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public static final String SUPPLIER_NAME = "Crazy Air";

    public List<CrazyAirResponseDTO> getFlights(CrazyAirRequestDTO crazyAirRequestDTO) {
        return null;
    }
}
