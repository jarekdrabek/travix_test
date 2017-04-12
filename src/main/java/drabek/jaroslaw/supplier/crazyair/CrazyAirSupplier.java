package drabek.jaroslaw.supplier.crazyair;

import com.beust.jcommander.internal.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrazyAirSupplier {

    public static final String SUPPLIER_NAME = "Crazy Air";

    public List<CrazyAirResponseDTO> getFlights(CrazyAirRequestDTO crazyAirRequestDTO) {
        return Lists.newArrayList();
    }
}
