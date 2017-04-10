package drabek.jaroslaw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public CrazyAirSupplier getCrazyAirSupplierStub(){
        return mock(CrazyAirSupplier.class);
    }

    @Bean
    public ToughJetSupplier getToughJetSupplierStub(){
        return mock(ToughJetSupplier.class);
    }
}
