package drabek.jaroslaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BusyFlightService {

    @Autowired
    ToughJetSupplier toughJetSupplier;

    @Autowired
    CrazyAirSupplier crazyAirSupplier;

    public Stream<Flight> search(SearchCriteriaVO searchCriteriaVO){
        return toughJetSupplier.getFlights(searchCriteriaVO);
    }
}
