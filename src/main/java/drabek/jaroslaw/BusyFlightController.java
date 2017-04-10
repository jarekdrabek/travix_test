package drabek.jaroslaw;

import com.beust.jcommander.internal.Lists;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BusyFlightController {

    @Autowired
    private BusyFlightService busyFlightService;

//    public BusyFlightController(BusyFlightService busyFlightService) {
//        this.busyFlightService = busyFlightService;
//    }

    @RequestMapping("/v1/flight")
    public List<Flight> index() {
        return busyFlightService.search(null).collect(Collectors.toList());
    }

}