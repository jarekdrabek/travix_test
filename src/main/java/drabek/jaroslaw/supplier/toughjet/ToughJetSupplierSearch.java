package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import drabek.jaroslaw.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ToughJetSupplierSearch implements FlightSupplierSearch {

    @Autowired
    private ToughJetClient toughJetClient;

    @Override
    public Stream<Flight> search(SearchCriteria search) {
        return Stream.empty();
    }
}
