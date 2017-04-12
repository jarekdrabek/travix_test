package drabek.jaroslaw;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteria {

    private Optional<String> origin;
    private Optional<String> destination;
    private Optional<LocalDate> departureDate;
    private Optional<LocalDate> returnDateDate;
    private int numberOfPassangers = 1;

    public SearchCriteria(Optional<String> origin, Optional<String> destination, Optional<LocalDate> departureDate, Optional<LocalDate> returnDateDate, int numberOfPassangers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDateDate = returnDateDate;
        this.numberOfPassangers = numberOfPassangers;
    }

    public Optional<String> getOrigin() {
        return origin;
    }

    public Optional<String> getDestination() {
        return destination;
    }

    public Optional<LocalDate> getDepartureDate() {
        return departureDate;
    }

    public Optional<LocalDate> getReturnDateDate() {
        return returnDateDate;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }
}
