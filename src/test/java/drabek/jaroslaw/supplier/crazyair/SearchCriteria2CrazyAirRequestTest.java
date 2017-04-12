package drabek.jaroslaw.supplier.crazyair;

import drabek.jaroslaw.SearchCriteria;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteria2CrazyAirRequestTest {

    @Test
    public void should_convert_search_criteria() {
        //given
        SearchCriteria toConvert = new SearchCriteria(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.of(LocalDate.of(2017, 4, 11)),
                Optional.of(LocalDate.of(2017, 4, 15)),
                1
        );
        //when
        CrazyAirRequestDTO converted = new SearchCriteria2CrazyAirRequest().toDTO(toConvert);
        //then
        Assertions.assertThat(converted).isEqualTo(new CrazyAirRequestDTO(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.of(LocalDate.of(2017, 4, 11)),
                Optional.of(LocalDate.of(2017, 4, 15)),
                1
        ));

    }
}