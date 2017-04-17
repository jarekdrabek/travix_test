package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.supplier.DTO2FlightConverter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class ToughJetResponse2Flight implements DTO2FlightConverter<ToughJetResponseDTO> {
    @Override
    public Flight fromDTO(ToughJetResponseDTO dto) {
        return new Flight(
                dto.getCarrier(),
                ToughJetSupplierSearch.SUPPLIER_NAME,
                PriceCalculator.base(new BigDecimal(dto.getBasePrice())).tax(new BigDecimal(dto.getTax())).discount(Integer.valueOf(dto.getDiscount())).calculate(),
                dto.getDepartureAirportName(),
                dto.getArrivalAirportName(),
                LocalDateTime.of(Integer.valueOf(dto.getDepartureYear()), Integer.valueOf(dto.getDepartureMonth()), Integer.valueOf(dto.getDepartureDay()), 12, 0),
                LocalDateTime.of(Integer.valueOf(dto.getReturnYear()), Integer.valueOf(dto.getReturnMonth()), Integer.valueOf(dto.getReturnDay()), 12, 0)
        );
    }
}
