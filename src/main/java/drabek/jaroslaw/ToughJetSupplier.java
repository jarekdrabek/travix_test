package drabek.jaroslaw;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Component
public class ToughJetSupplier implements FlightSupplier {


    public static final String TOUGH_JET_NAME = "ToughJet";

    @Override
    public Stream<Flight> getFlights(SearchCriteriaVO search) {
        return Stream.of(
                new Flight("British Airways", TOUGH_JET_NAME, new BigDecimal("123.21"),
                        IATACode.of("KRK"), IATACode.of("STD"),
                        LocalDateTime.of(2017, 04, 7, 12, 30), LocalDateTime.of(2017, 04, 7, 13, 35))
                ,new Flight("LOT Airlines", TOUGH_JET_NAME, new BigDecimal("123.21"),
                        IATACode.of("KRK"), IATACode.of("LUT"),
                        LocalDateTime.of(2017, 04, 8, 8, 50), LocalDateTime.of(2017, 04, 8, 9, 55))
        );
    }
}
