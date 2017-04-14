package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BusyFlightController {

    @Autowired
    private BusyFlightService busyFlightService;

    @RequestMapping(value = "/v1/flight", method = GET)
    public List<Flight> search(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("departureDate") LocalDate departureDate,
            @RequestParam("returnDate") LocalDate returnDate,
            @RequestParam("numberOfPassengers") int numberOfPassengers) {
        return busyFlightService.search(
                lookingForFlight()
                        .from(origin)
                        .to(destination)
                        .on(departureDate)
                        .back(returnDate)
                        .count(numberOfPassengers)
                        .create()
        ).collect(Collectors.toList());
    }

}