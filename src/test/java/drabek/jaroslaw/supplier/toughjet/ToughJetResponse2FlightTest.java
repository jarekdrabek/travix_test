package drabek.jaroslaw.supplier.toughjet;

import drabek.jaroslaw.Flight;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ToughJetResponse2FlightTest {


    @Test
    public void should_convert_to_flight(){
        //given

        ToughJetResponseDTO toBeConverted = new ToughJetResponseDTO(
                "British Airways",
                "123.45",
                "25.12",
                "20",
                "STD",
                "KRK",
                12,
                4,
                2017,
                13,
                5,
                2017
        );
        //when
        Flight converted = new ToughJetResponse2Flight().fromDTO(toBeConverted);
        //then
        assertThat(converted).isEqualTo(new Flight(
                "British Airways",
                "Tough Jet",
                new BigDecimal("118.856"),
                "STD",
                "KRK",
                LocalDateTime.of(2017, 4, 12, 12, 0),
                LocalDateTime.of(2017, 5, 13, 12, 0)
        ));
    }

}