package drabek.jaroslaw.supplier.crazyair;

import java.time.LocalDateTime;

public class CrazyAirResponseDTO {
    private String airline;
    private String price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public CrazyAirResponseDTO(
            String airline,
            String price,
            String cabinclass,
            String departureAirportCode,
            String destinationAirportCode,
            LocalDateTime departureDate,
            LocalDateTime arrivalDate
    ) {
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getPrice() {
        return price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
}
