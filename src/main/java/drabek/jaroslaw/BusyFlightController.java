package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BusyFlightController {

    @Autowired
    private BusyFlightService busyFlightService;

    @RequestMapping("/v1/flight")
    public List<Flight> index() {
        return busyFlightService.search(null).collect(Collectors.toList());
    }

}