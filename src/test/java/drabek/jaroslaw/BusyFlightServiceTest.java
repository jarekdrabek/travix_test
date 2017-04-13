package drabek.jaroslaw;

import drabek.jaroslaw.supplier.crazyair.CrazyAirSupplierSearch;
import drabek.jaroslaw.supplier.toughjet.ToughJetSupplierSearch;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Stream;

import static drabek.jaroslaw.SearchCriteriaBuilder.lookingForFlight;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class BusyFlightServiceTest {

    @Mock
    private ToughJetSupplierSearch toughJetSupplierSearch;

    @Mock
    private CrazyAirSupplierSearch crazyAirSupplierSearch;

    @Captor
    private ArgumentCaptor<SearchCriteria> crazyAirSearchArgumentCaptor;

    @Captor
    private ArgumentCaptor<SearchCriteria> toughJetSearchArgumentCaptor;

    @InjectMocks
    private BusyFlightService underTest;

    @Test
    public void should_search_flights_in_toughJet_supplier_search() {
        //given
        doReturn(Stream.empty()).when(crazyAirSupplierSearch).search(any());
        doReturn(Stream.empty()).when(toughJetSupplierSearch).search(any());
        //when
        underTest.search(lookingForFlight().from("BER").create());
        //then
        verify(toughJetSupplierSearch).search(toughJetSearchArgumentCaptor.capture());
        Assertions.assertThat(
                toughJetSearchArgumentCaptor.getValue()
        ).isEqualTo(
                lookingForFlight().from("BER").create()
        );
    }

    @Test
    public void should_search_flights_in_crazyAir_supplier_search() {
        //given
        doReturn(Stream.empty()).when(crazyAirSupplierSearch).search(any());
        doReturn(Stream.empty()).when(toughJetSupplierSearch).search(any());
        //when
        underTest.search(lookingForFlight().from("STD").create());
        //then
        verify(crazyAirSupplierSearch).search(crazyAirSearchArgumentCaptor.capture());
        Assertions.assertThat(
                crazyAirSearchArgumentCaptor.getValue()
        ).isEqualTo(
                lookingForFlight().from("STD").create()
        );

    }
}