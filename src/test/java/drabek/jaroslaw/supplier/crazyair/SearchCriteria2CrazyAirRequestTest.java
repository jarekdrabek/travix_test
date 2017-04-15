package drabek.jaroslaw.supplier.crazyair;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import drabek.jaroslaw.SearchCriteria;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchCriteria2CrazyAirRequestTest {

    @Test
    public void should_convert_complete_search_criteria(){
        //given
        SearchCriteria toBeConverted = new SearchCriteria(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.of(LocalDate.of(2017, 4, 11)),
                Optional.of(LocalDate.of(2017, 4, 15)),
                1
        );
        HashMap<String, List<String>> expectedMap = Maps.newHashMap();
        expectedMap.put("origin",Lists.newArrayList("KRK"));
        expectedMap.put("destination",Lists.newArrayList("STD"));
        expectedMap.put("departureDate",Lists.newArrayList("2017-04-11"));
        expectedMap.put("returnDate",Lists.newArrayList("2017-04-15"));
        expectedMap.put("numberOfPassengers",Lists.newArrayList("1"));
        //when
        MultiValueMap<String, String> converted = new SearchCriteria2CrazyAirRequest().toMap(toBeConverted);
        //then
        assertThat(converted).isEqualTo(CollectionUtils.toMultiValueMap(expectedMap));
    }

    @Test
    public void should_convert_incomplete_search_criteria() {
        //given
        SearchCriteria toBeConverted = new SearchCriteria(
                Optional.of("KRK"),
                Optional.of("STD"),
                Optional.empty(),
                Optional.empty(),
                1
        );
        HashMap<String, List<String>> expectedMap = Maps.newHashMap();
        expectedMap.put("origin",Lists.newArrayList("KRK"));
        expectedMap.put("destination",Lists.newArrayList("STD"));
        expectedMap.put("numberOfPassengers",Lists.newArrayList("1"));
        //when
        MultiValueMap<String, String> converted = new SearchCriteria2CrazyAirRequest().toMap(toBeConverted);
        //then
        assertThat(converted).isEqualTo(CollectionUtils.toMultiValueMap(expectedMap));
    }

}