package drabek.jaroslaw;

import com.beust.jcommander.internal.Lists;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BusyFlightController {

    @RequestMapping("/v1/flight")
    public List<Flight2> index() {
        return Lists.newArrayList(
                new Flight2(LocalDateTime.of(2017, 04, 7, 13, 35), new BigDecimal("123.44"), IATACode.of("STD")),
                new Flight2(LocalDateTime.of(2017, 04, 8, 13, 35), new BigDecimal("433.21"), IATACode.of("KRK"))
        );
    }

}