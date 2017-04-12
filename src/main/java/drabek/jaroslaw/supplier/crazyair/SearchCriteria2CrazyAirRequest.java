package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.supplier.SearchCriteria2DTOConverter;
import org.springframework.stereotype.Component;

@Component
public class SearchCriteria2CrazyAirRequest implements SearchCriteria2DTOConverter<CrazyAirRequestDTO>{

    @Override
    public CrazyAirRequestDTO toDTO(SearchCriteria searchCriteria) {
        return new CrazyAirRequestDTO(
                searchCriteria.getOrigin(),
                searchCriteria.getDestination(),
                searchCriteria.getDepartureDate(),
                searchCriteria.getReturnDate(),
                searchCriteria.getNumberOfPassangers()
        );
    }
}
