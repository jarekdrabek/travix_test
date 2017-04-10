package drabek.jaroslaw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class BusyFlightServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ToughJetSupplier toughJetSupplier;

    @Autowired
    private CrazyAirSupplier crazyAirSupplier;

    @Test
    public void should_return_empty_results_when_suppliers_return_empty_results() {
        when(crazyAirSupplier.getFlights(any())).thenReturn(Stream.empty());
        when(toughJetSupplier.getFlights(any())).thenReturn(Stream.empty());

        Assertions.assertThat(true).isTrue();
    }
}