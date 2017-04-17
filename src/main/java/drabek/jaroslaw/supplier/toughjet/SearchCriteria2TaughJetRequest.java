package drabek.jaroslaw.supplier.toughjet;

import com.google.common.collect.Maps;
import drabek.jaroslaw.SearchCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class SearchCriteria2TaughJetRequest {

    public MultiValueMap<String,String> toMap(SearchCriteria searchCriteria){
        Map<String, List<String>> mapToReturn = Maps.newHashMap();
        searchCriteria.getOrigin().ifPresent(value -> mapToReturn.put("from", newArrayList(value)));
        searchCriteria.getDestination().ifPresent(value -> mapToReturn.put("to", newArrayList(value)));
        searchCriteria.getDepartureDate().ifPresent(value -> {
            mapToReturn.put("departureDay", newArrayList(String.valueOf(value.getDayOfMonth())));
            mapToReturn.put("departureMonth", newArrayList(String.valueOf(value.getMonthValue())));
            mapToReturn.put("departureYear", newArrayList(String.valueOf(value.getYear())));
        });
        searchCriteria.getReturnDate().ifPresent(value -> {
            mapToReturn.put("returnDay", newArrayList(String.valueOf(value.getDayOfMonth())));
            mapToReturn.put("returnMonth", newArrayList(String.valueOf(value.getMonthValue())));
            mapToReturn.put("returnYear", newArrayList(String.valueOf(value.getYear())));
        });
        mapToReturn.put("numberOfAdults", newArrayList(String.valueOf(searchCriteria.getNumberOfPassengers())));
        return CollectionUtils.toMultiValueMap(mapToReturn);
    }

}
