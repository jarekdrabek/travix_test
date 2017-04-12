package drabek.jaroslaw;

import java.util.stream.Stream;

public interface FlightSupplier {
    Stream<Flight> getFlights(SearchCriteria search);
}
