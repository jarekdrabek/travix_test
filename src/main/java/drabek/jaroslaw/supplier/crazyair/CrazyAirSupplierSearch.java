package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearch implements FlightSupplierSearch {

    @Autowired
    private CrazyAirSupplier crazyAirSupplier;

    @Autowired
    private SearchCriteria2CrazyAirRequest searchCriteriaConverter;

    @Autowired
    private CrazyAirResponse2Flight crazyAirResponse2Flight;

    @Override
    public Stream<Flight> search(SearchCriteria search) {
        return crazyAirSupplier.getFlights(searchCriteriaConverter.toDTO(search)).stream()
                .map(dto -> crazyAirResponse2Flight.fromDTO(dto));
    }

}
