package drabek.jaroslaw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.stream.Stream;

import static drabek.jaroslaw.FlightBuilder.flight;
import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class BusyFlightServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private ToughJetSupplier toughJetSupplier;

    @Mock
    private CrazyAirSupplier crazyAirSupplier;

    @InjectMocks
    private BusyFlightService underTest;

    @Test
    public void should_return_results_from_toughJetSupplier() {
        doReturn(Stream.empty()).when(crazyAirSupplier).getFlights(any());

        doReturn(Stream.of(
                flight().from("KRK").to("FUE").create()
        )).when(toughJetSupplier).getFlights(any());

        Stream<Flight> searchResults = underTest.search(lookingForFlight().from("KRK").create());
        Assertions.assertThat(searchResults.count()).isEqualTo(1);
    }


}