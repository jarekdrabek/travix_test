package drabek.jaroslaw;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equal(airline, flight.airline) &&
                Objects.equal(supplier, flight.supplier) &&
                Objects.equal(fare, flight.fare) &&
                Objects.equal(departureAirport, flight.departureAirport) &&
                Objects.equal(destinationAirport, flight.destinationAirport) &&
                Objects.equal(departureDate, flight.departureDate) &&
                Objects.equal(arrivalDate, flight.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(airline, supplier, fare, departureAirport, destinationAirport, departureDate, arrivalDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("airline='").append(airline).append('\'');
        sb.append(", supplier='").append(supplier).append('\'');
        sb.append(", fare=").append(fare);
        sb.append(", departureAirport='").append(departureAirport).append('\'');
        sb.append(", destinationAirport='").append(destinationAirport).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append('}');
        return sb.toString();
    }
}
