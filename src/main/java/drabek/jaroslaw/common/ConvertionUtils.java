package drabek.jaroslaw.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertionUtils {

    public static String convertLocalDateToISO8601String(LocalDate value) {
        return value.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
