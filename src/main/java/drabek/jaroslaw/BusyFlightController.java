package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BusyFlightController {

    @Autowired
    private BusyFlightService busyFlightService;

    @RequestMapping(value = "/v1/flight", method = GET)
    public List<Flight> search(
            @RequestParam(value = "origin", required = false) String origin,
            @RequestParam(value = "destination", required = false) String destination,
            @RequestParam(value = "departureDate", required = false) LocalDate departureDate,
            @RequestParam(value = "returnDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
            @RequestParam(value = "numberOfPassengers", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Integer numberOfPassengers
    ) {
        Stream<Flight> search = busyFlightService.search(
                lookingForFlight()
                        .from(origin)
                        .to(destination)
                        .on(departureDate)
                        .back(returnDate)
                        .count(numberOfPassengers)
                        .create()
        );
        List<Flight> results = search.collect(Collectors.toList());
        return results;
    }

}