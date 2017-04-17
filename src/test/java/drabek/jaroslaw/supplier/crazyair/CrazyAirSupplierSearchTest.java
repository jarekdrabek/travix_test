package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import drabek.jaroslaw.supplier.SupplierErrorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CrazyAirSupplierSearchTest {

    @Mock
    private CrazyAirClient crazyAirClient;

    @Mock
    private SearchCriteria2CrazyAirRequest searchCriteriaConverter;

    @InjectMocks
    private CrazyAirSupplierSearch crazyAirSupplierSearch;

    @Test
    public void should_return_empty_stream_when_supplier_error_exception(){
        //given
        when(crazyAirClient.getFlights(any())).thenThrow(SupplierErrorException.class);
        //when
        Stream<Flight> results = crazyAirSupplierSearch.search(any());
        //then
        assertThat(results).isEmpty();
    }

}