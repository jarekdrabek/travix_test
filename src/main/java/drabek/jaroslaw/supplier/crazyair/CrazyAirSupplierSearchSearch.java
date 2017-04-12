package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import drabek.jaroslaw.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearchSearch implements FlightSupplierSearch {

    @Autowired
    private CrazyAirSupplier crazyAirSupplier;

    @Override
    public Stream<Flight> getFlights(SearchCriteria search) {
        return Stream.of();
    }

}
