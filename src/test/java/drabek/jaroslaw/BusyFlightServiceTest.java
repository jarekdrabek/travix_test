package drabek.jaroslaw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static drabek.jaroslaw.FlightBuilder.flight;
import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class BusyFlightServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private ToughJetSupplierSearch toughJetSupplierSearch;

    @Mock
    private CrazyAirSupplierSearch crazyAirSupplierSearch;

    @InjectMocks
    private BusyFlightService underTest;

    @Test
    public void should_return_results_from_toughJet_supplier() {
        doReturn(Stream.empty()).when(crazyAirSupplierSearch).getFlights(any());
        doReturn(Stream.of(
                flight().from("KRK").to("FUE").create()
        )).when(toughJetSupplierSearch).getFlights(any());

        List<Flight> searchResults = underTest.search(lookingForFlight().from("KRK").create()).collect(Collectors.toList());

        Assertions.assertThat(searchResults).contains(flight().from("KRK").to("FUE").create());
        Assertions.assertThat(searchResults.size()).isEqualTo(1);
    }

    @Test
    public void should_return_results_from_crazyAir_supplier() {
        doReturn(Stream.of(
                flight().from("BER").to("STD").create()
        )).when(crazyAirSupplierSearch).getFlights(any());
        doReturn(Stream.empty()).when(toughJetSupplierSearch).getFlights(any());

        List<Flight> searchResults = underTest.search(lookingForFlight().from("BER").create()).collect(Collectors.toList());

        Assertions.assertThat(searchResults).contains(flight().from("BER").to("STD").create());
        Assertions.assertThat(searchResults.size()).isEqualTo(1);
    }
}