package drabek.jaroslaw.supplier.crazyair;

import com.google.common.collect.Maps;
import drabek.jaroslaw.SearchCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static drabek.jaroslaw.common.ISO8601Utils.convertLocalDateToISO8601String;

@Component
public class SearchCriteria2CrazyAirRequest {

    public MultiValueMap<String,String> toMap(SearchCriteria searchCriteria){
        Map<String, List<String>> mapToReturn = Maps.newHashMap();
        searchCriteria.getOrigin().ifPresent(value -> mapToReturn.put("origin", newArrayList(value)));
        searchCriteria.getDestination().ifPresent(value -> mapToReturn.put("destination", newArrayList(value)));
        searchCriteria.getDepartureDate().ifPresent(value -> mapToReturn.put("departureDate", newArrayList(convertLocalDateToISO8601String(value))));
        searchCriteria.getReturnDate().ifPresent(value -> mapToReturn.put("returnDate", newArrayList(convertLocalDateToISO8601String(value))));
        mapToReturn.put("numberOfPassengers", newArrayList(String.valueOf(searchCriteria.getNumberOfPassengers())));
        return CollectionUtils.toMultiValueMap(mapToReturn);
    }

}
