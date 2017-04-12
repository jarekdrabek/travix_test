package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
public class BusyFlightService {

    @Autowired
    ToughJetSupplier toughJetSupplier;

    @Autowired
    CrazyAirSupplier crazyAirSupplier;

    public BusyFlightService() {
    }

    public Stream<Flight> search(SearchCriteria searchCriteria){
        return Stream.concat(toughJetSupplier.getFlights(searchCriteria), crazyAirSupplier.getFlights(searchCriteria));
    }
}