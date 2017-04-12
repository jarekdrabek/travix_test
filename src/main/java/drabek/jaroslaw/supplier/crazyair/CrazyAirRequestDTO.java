package drabek.jaroslaw.supplier.crazyair;

import java.time.LocalDate;
import java.util.Optional;

public class CrazyAirRequestDTO {

    private Optional<String> origin;
    private Optional<String> destination;
    private Optional<LocalDate> departureDate;
    private Optional<LocalDate> returnDate;
    private int numberOfPassangers;

    public CrazyAirRequestDTO(Optional<String> origin, Optional<String> destination, Optional<LocalDate> departureDate, Optional<LocalDate> returnDate, int numberOfPassangers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
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

    public Optional<LocalDate> getReturnDate() {
        return returnDate;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }
}
