package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.FlightSupplierSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class CrazyAirSupplierSearchSearch implements FlightSupplierSearch {

    @Autowired
    private CrazyAirSupplier crazyAirSupplier;

    @Autowired
    private SearchCriteria2CrazyAirRequest searchCriteriaConverter;

    @Autowired
    private CrazyAirResponse2Flight crazyAirResponse2Flight;

    @Override
    public Stream<Flight> getFlights(SearchCriteria search) {
        CrazyAirRequestDTO crazyAirRequestDTO = searchCriteriaConverter.toDTO(search);
        List<CrazyAirResponseDTO> responses = crazyAirSupplier.getFlights(crazyAirRequestDTO);
        return null;
    }

}
