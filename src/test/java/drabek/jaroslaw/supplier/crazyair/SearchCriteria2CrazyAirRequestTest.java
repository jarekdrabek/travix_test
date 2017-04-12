package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.SearchCriteria;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchCriteria2CrazyAirRequestTest {

    @Test
    public void should_convert_search_criteria() {
        //given
        SearchCriteria toBeConverted = new SearchCriteria(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.of(LocalDate.of(2017, 4, 11)),
                Optional.of(LocalDate.of(2017, 4, 15)),
                1
        );
        //when
        CrazyAirRequestDTO converted = new SearchCriteria2CrazyAirRequest().toDTO(toBeConverted);
        //then
        assertThat(converted).isEqualTo(new CrazyAirRequestDTO(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.of(LocalDate.of(2017, 4, 11)),
                Optional.of(LocalDate.of(2017, 4, 15)),
                1
        ));

    }
}