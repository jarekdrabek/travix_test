package drabek.jaroslaw;

import drabek.jaroslaw.supplier.crazyair.CrazyAirSupplierSearchSearch;
import drabek.jaroslaw.supplier.toughjet.ToughJetSupplierSearchSearch;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class BusyFlightServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private ToughJetSupplierSearchSearch toughJetSupplierSearch;

    @Mock
    private CrazyAirSupplierSearchSearch crazyAirSupplierSearch;

    @Captor
    private ArgumentCaptor<SearchCriteria> crazyAirSearchArgumentCaptor;

    @Captor
    private ArgumentCaptor<SearchCriteria> toughJetSearchArgumentCaptor;

    @InjectMocks
    private BusyFlightService underTest;

    @Test
    public void should_search_flights_in_toughJet_supplier_search() {
        //given
        doReturn(Stream.empty()).when(crazyAirSupplierSearch).getFlights(any());
        doReturn(Stream.empty()).when(toughJetSupplierSearch).getFlights(any());
        //when
        underTest.search(lookingForFlight().from("BER").create());
        //then
        verify(toughJetSupplierSearch).getFlights(toughJetSearchArgumentCaptor.capture());
        Assertions.assertThat(
                toughJetSearchArgumentCaptor.getValue()
        ).isEqualTo(
                lookingForFlight().from("BER").create()
        );
    }

    @Test
    public void should_search_flights_in_crazyAir_supplier_search() {
        //given
        doReturn(Stream.empty()).when(crazyAirSupplierSearch).getFlights(any());
        doReturn(Stream.empty()).when(toughJetSupplierSearch).getFlights(any());
        //when
        underTest.search(lookingForFlight().from("STD").create());
        //then
        verify(crazyAirSupplierSearch).getFlights(crazyAirSearchArgumentCaptor.capture());
        Assertions.assertThat(
                crazyAirSearchArgumentCaptor.getValue()
        ).isEqualTo(
                lookingForFlight().from("STD").create()
        );

    }
}