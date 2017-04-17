package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearch implements FlightSupplierSearch {

    private static final Logger LOG = LoggerFactory.getLogger(CrazyAirSupplierSearch.class);

    public static final String SUPPLIER_NAME = "Crazy Air";

    @Autowired
    private CrazyAirClient crazyAirClient;

    @Autowired
    private SearchCriteria2CrazyAirRequest searchCriteriaConverter;

    @Autowired
    private CrazyAirResponse2Flight crazyAirResponse2Flight;

    @Override
    public Stream<Flight> search(SearchCriteria search) {
        Stream<Flight> results = null;
        try {
            results = crazyAirClient.getFlights(searchCriteriaConverter.toMap(search)).stream().map(dto -> crazyAirResponse2Flight.fromDTO(dto));
        } catch (Exception e) {
            LOG.error("CrazyAir Supplier 500 Error. Returning empty results");
            return Stream.empty();
        }
        return results;
    }

}
