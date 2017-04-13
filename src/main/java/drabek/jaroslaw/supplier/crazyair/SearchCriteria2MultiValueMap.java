package drabek.jaroslaw.supplier.crazyair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Maps;
import drabek.jaroslaw.SearchCriteria;
import drabek.jaroslaw.SearchCriteriaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class SearchCriteria2MultiValueMap {

    private static final Logger LOG = LoggerFactory.getLogger(SearchCriteria2MultiValueMap.class);

    private ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();

    public MultiValueMap<String,String> toMap(SearchCriteria searchCriteria){
        Map<String, List<String>> mapToReturn = Maps.newHashMap();
        searchCriteria.getOrigin().ifPresent(value -> mapToReturn.put("origin", newArrayList(value)));
        searchCriteria.getDestination().ifPresent(value -> mapToReturn.put("destination", newArrayList(value)));
        searchCriteria.getDepartureDate().ifPresent(value -> mapToReturn.put("departureDate", newArrayList(convertLocalDateToISO8601String(value))));
        searchCriteria.getDepartureDate().ifPresent(value -> mapToReturn.put("returnDate", newArrayList(convertLocalDateToISO8601String(value))));
        mapToReturn.put("numberOfPassengers", newArrayList(String.valueOf(searchCriteria.getNumberOfPassengers())));
        return CollectionUtils.toMultiValueMap(mapToReturn);
    }

    private String convertLocalDateToISO8601String(LocalDate value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LOG.error("Error while serializing object", e);
            return "Unconvertable value";
        }
    }
}
