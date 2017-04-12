package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
public class BusyFlightService {

    @Autowired
    ToughJetSupplierSearch toughJetSupplierSearch;

    @Autowired
    CrazyAirSupplierSearch crazyAirSupplierSearch;

    public Stream<Flight> search(SearchCriteria searchCriteria){
        return Stream.concat(toughJetSupplierSearch.getFlights(searchCriteria), crazyAirSupplierSearch.getFlights(searchCriteria));
    }
}