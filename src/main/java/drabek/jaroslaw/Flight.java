package drabek.jaroslaw;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {
    String airline;
    String supplier;
    BigDecimal fare;
    String departureAirport;
    String destinationAirport;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;

    public Flight(String airline,
                  String supplier,
                  BigDecimal fare,
                  String departureAirport, String destinationAirport, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
}
