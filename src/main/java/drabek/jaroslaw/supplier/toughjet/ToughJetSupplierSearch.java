package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import drabek.jaroslaw.supplier.SupplierErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ToughJetSupplierSearch implements FlightSupplierSearch {

    private static final Logger LOG = LoggerFactory.getLogger(ToughJetSupplierSearch.class);

    public static final String SUPPLIER_NAME = "Tough Jet";

    @Autowired
    private ToughJetClient toughJetClient;

    @Autowired
    private SearchCriteria2TaughJetRequest searchCriteria2TaughJetRequest;

    @Autowired
    private ToughJetResponse2Flight toughJetResponse2Flight;

    @Override
    public Stream<Flight> search(SearchCriteria search) {
        Stream<Flight> results = null;
        try {
            results = toughJetClient.getFlights(searchCriteria2TaughJetRequest.toMap(search)).stream().map(dto -> toughJetResponse2Flight.fromDTO(dto));
        } catch (SupplierErrorException e) {
            LOG.error("Tough Jet Supplier 500 Error. Returning empty results");
            return Stream.empty();
        } catch (Exception e){
            LOG.error("Tough Jet Supplier Unknown error. Returning empty results");
            return Stream.empty();
        }
        return results;
    }
}
