package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.Flight;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CrazyAirResponse2FlightTest {

    @Test
    public void should_convert_to_flight(){
        //given
        CrazyAirResponseDTO toBeConverted = new CrazyAirResponseDTO(
                "British Airways",
                "123.45",
                "E",
                "STD",
                "KRK",
                LocalDateTime.of(2017, 4, 12, 13, 15),
                LocalDateTime.of(2017, 4, 12, 14, 30)
        );
        //when
        Flight converted = new CrazyAirResponse2Flight().fromDTO(toBeConverted);
        //then
        assertThat(converted).isEqualTo(new Flight(
                "British Airways",
                "Crazy Air",
                new BigDecimal("123.45"),
                "STD",
                "KRK",
                LocalDateTime.of(2017, 4, 12, 13, 15),
                LocalDateTime.of(2017, 4, 12, 14, 30)
        ));
    }
}