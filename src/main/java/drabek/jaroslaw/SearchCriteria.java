package drabek.jaroslaw;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteria that = (SearchCriteria) o;
        return numberOfPassangers == that.numberOfPassangers &&
                Objects.equal(origin, that.origin) &&
                Objects.equal(destination, that.destination) &&
                Objects.equal(departureDate, that.departureDate) &&
                Objects.equal(returnDateDate, that.returnDateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(origin, destination, departureDate, returnDateDate, numberOfPassangers);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchCriteria{");
        sb.append("origin=").append(origin);
        sb.append(", destination=").append(destination);
        sb.append(", departureDate=").append(departureDate);
        sb.append(", returnDateDate=").append(returnDateDate);
        sb.append(", numberOfPassangers=").append(numberOfPassangers);
        sb.append('}');
        return sb.toString();
    }
}
