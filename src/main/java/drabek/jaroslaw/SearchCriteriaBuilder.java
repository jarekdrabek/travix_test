package drabek.jaroslaw;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteriaBuilder {
    private Optional<String> origin = Optional.empty();
    private Optional<String> destination = Optional.empty();
    private Optional<LocalDate> departureDate = Optional.empty();
    private Optional<LocalDate> returnDateDate = Optional.empty();
    private int numberOfPassangers = 1;

    public static SearchCriteriaBuilder lookingForFlight() {
        return new SearchCriteriaBuilder();
    }

    public SearchCriteriaBuilder from(String origin) {
        this.origin = Optional.ofNullable(origin);
        return this;
    }

    public SearchCriteriaBuilder to(String destination) {
        this.destination = Optional.ofNullable(destination);
        return this;
    }

    public SearchCriteriaBuilder on(LocalDate departureDate) {
        this.departureDate = Optional.ofNullable(departureDate);
        return this;
    }

    public SearchCriteriaBuilder back(LocalDate returnDateDate) {
        this.returnDateDate = Optional.ofNullable(returnDateDate);
        return this;
    }

    public SearchCriteriaBuilder count(Integer numberOfPassangers) {
        this.numberOfPassangers = Optional.ofNullable(numberOfPassangers).orElse(1);
        return this;
    }

    public SearchCriteria create() {
        return new SearchCriteria(origin, destination, departureDate, returnDateDate, numberOfPassangers);
    }
}