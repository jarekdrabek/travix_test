package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearch implements FlightSupplierSearch {

    public static final String SUPPLIER_NAME = "Crazy Air";

    @Autowired
    private CrazyAirClient crazyAirClient;

    @Autowired
    private SearchCriteria2MultiValueMap searchCriteriaConverter;

    @Autowired
    private CrazyAirResponse2Flight crazyAirResponse2Flight;

    @Override
    public Stream<Flight> search(SearchCriteria search) {
//        return crazyAirClient.getFlights(searchCriteriaConverter.toMap(search)).stream()
//                .map(dto -> crazyAirResponse2Flight.fromDTO(dto));
        return null;
    }

}
