package drabek.jaroslaw;

import drabek.jaroslaw.supplier.crazyair.CrazyAirSupplierSearch;
import drabek.jaroslaw.supplier.toughjet.ToughJetSupplierSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
public class BusyFlightService {

    @Autowired
    private ToughJetSupplierSearch toughJetSupplierSearch;

    @Autowired
    private CrazyAirSupplierSearch crazyAirSupplierSearch;

    public Stream<Flight> search(SearchCriteria searchCriteria){
        return Stream.concat(
                crazyAirSupplierSearch.search(searchCriteria),
                toughJetSupplierSearch.search(searchCriteria)
        );
    }
}