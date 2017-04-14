package drabek.jaroslaw.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;

public class ConvertionUtils {


    public static String convertLocalDateToISO8601String(LocalDate value) {
        try {
            return new Jackson2ObjectMapperBuilder()
                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .build()
                    .writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Unconvertable value";
        }
    }
}
