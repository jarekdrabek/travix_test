package drabek.jaroslaw.supplier;

import drabek.jaroslaw.Application;
import drabek.jaroslaw.BusyFlightService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public BusyFlightService getBusyFlightService(){
        return Mockito.mock(BusyFlightService.class);
    }
}
