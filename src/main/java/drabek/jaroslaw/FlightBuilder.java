package drabek.jaroslaw;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightBuilder {
    private String airline = "Testing Airways";
    private String supplier = "Testing-Supplier";
    private BigDecimal fare = new BigDecimal("123.45");
    private String departureAirport = "KRK";
    private String destinationAirport = "STD";
    private LocalDateTime departureDate = LocalDateTime.of(2017, 04, 7, 12, 30);
    private LocalDateTime arrivalDate = LocalDateTime.of(2017, 04, 7, 15, 30);

    public static FlightBuilder flight(){
        return new FlightBuilder();
    }

    private FlightBuilder() {
    }

    public FlightBuilder withAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public FlightBuilder withSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public FlightBuilder forFare(BigDecimal fare) {
        this.fare = fare;
        return this;
    }

    public FlightBuilder from(String departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public FlightBuilder to(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public FlightBuilder leavingAt(LocalDateTime departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public FlightBuilder arrivalAt(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public Flight create() {
        return new Flight(airline, supplier, fare, departureAirport, destinationAirport, departureDate, arrivalDate);
    }
}