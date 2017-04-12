package drabek.jaroslaw.supplier.crazyair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CrazyAirResponseDTO {
    String airline;
    int price;
    String cabinclass;
    String departureAirportCode;
    String destinationAirportCode;
    String departureDate;
    String arrivalDate;

    @JsonCreator
    public CrazyAirResponseDTO(
            @JsonProperty("airline") String airline,
            @JsonProperty("price") int price,
            @JsonProperty("cabinclass") String cabinclass,
            @JsonProperty("departureAirportCode") String departureAirportCode,
            @JsonProperty("destinationAirportCode") String destinationAirportCode,
            @JsonProperty("departureDate") String departureDate,
            @JsonProperty("arrivalDate") String arrivalDate
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

    public int getPrice() {
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

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
