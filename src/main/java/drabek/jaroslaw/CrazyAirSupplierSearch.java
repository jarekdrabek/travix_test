package drabek.jaroslaw;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearch implements FlightSupplier{

    public static final String TOUGH_JET_NAME = "CrazyAir";

    @Override
    public Stream<Flight> getFlights(SearchCriteria search) {
        return Stream.of();
    }

}
