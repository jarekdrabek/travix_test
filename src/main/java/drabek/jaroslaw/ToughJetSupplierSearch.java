package drabek.jaroslaw;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ToughJetSupplierSearch implements FlightSupplier{

    public static final String TOUGH_JET_NAME = "ToughJet";

    @Override
    public Stream<Flight> getFlights(SearchCriteria search) {
        return Stream.empty();
    }
}
