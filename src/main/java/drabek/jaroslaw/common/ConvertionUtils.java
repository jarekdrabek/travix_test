package drabek.jaroslaw.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertionUtils {

    public static String convertLocalDateToISO8601String(LocalDate value) {
        return value.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
