package drabek.jaroslaw.supplier;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;

import java.util.stream.Stream;

public interface FlightSupplierSearch {
    Stream<Flight> search(SearchCriteria search);
}
