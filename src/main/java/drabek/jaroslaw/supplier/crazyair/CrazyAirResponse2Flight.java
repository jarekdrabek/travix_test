package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.supplier.DTO2FlightConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CrazyAirResponse2Flight implements DTO2FlightConverter<CrazyAirResponseDTO> {
    @Override
    public Flight fromDTO(CrazyAirResponseDTO dto) {
        return new Flight(
                dto.getAirline(),
                CrazyAirSupplierSearch.SUPPLIER_NAME,
                new BigDecimal(dto.getPrice()),
                dto.getDepartureAirportCode(),
                dto.getDestinationAirportCode(),
                dto.getDepartureDate(),
                dto.getArrivalDate()
        );
    }
}
