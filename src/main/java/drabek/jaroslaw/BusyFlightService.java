package drabek.jaroslaw;

import drabek.jaroslaw.supplier.crazyair.CrazyAirSupplierSearchSearch;
import drabek.jaroslaw.supplier.toughjet.ToughJetSupplierSearchSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
public class BusyFlightService {

    @Autowired
    private ToughJetSupplierSearchSearch toughJetSupplierSearch;

    @Autowired
    private CrazyAirSupplierSearchSearch crazyAirSupplierSearch;

    public Stream<Flight> search(SearchCriteria searchCriteria){
        return Stream.concat(
                toughJetSupplierSearch.getFlights(searchCriteria),
                crazyAirSupplierSearch.getFlights(searchCriteria)
        );
    }
}