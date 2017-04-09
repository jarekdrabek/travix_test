package drabek.jaroslaw;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {
    String airline;
    String supplier;
    BigDecimal fare;
    IATACode departureAirport;
    IATACode destinationAirport;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;


    public Flight(String airline, String supplier, BigDecimal fare, IATACode departureAirport, IATACode destinationAirport, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
}
