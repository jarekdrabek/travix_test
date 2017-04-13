package drabek.jaroslaw;

import com.google.common.base.Objects;

import java.time.LocalDate;
import java.util.Optional;

public class SearchCriteria {

    private Optional<String> origin;
    private Optional<String> destination;
    private Optional<LocalDate> departureDate;
    private Optional<LocalDate> returnDate;
    private int numberOfPassengers = 1;

    public SearchCriteria(Optional<String> origin, Optional<String> destination, Optional<LocalDate> departureDate, Optional<LocalDate> returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
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

    public Optional<LocalDate> getReturnDate() {
        return returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteria that = (SearchCriteria) o;
        return numberOfPassengers == that.numberOfPassengers &&
                Objects.equal(origin, that.origin) &&
                Objects.equal(destination, that.destination) &&
                Objects.equal(departureDate, that.departureDate) &&
                Objects.equal(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(origin, destination, departureDate, returnDate, numberOfPassengers);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchCriteria{");
        sb.append("origin=").append(origin);
        sb.append(", destination=").append(destination);
        sb.append(", departureDate=").append(departureDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", numberOfPassengers=").append(numberOfPassengers);
        sb.append('}');
        return sb.toString();
    }
}
