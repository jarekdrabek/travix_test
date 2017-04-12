package drabek.jaroslaw.supplier.crazyair;

public class CrazyAirResponseDTO {
    private String airline;
    private int price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public CrazyAirResponseDTO(
            String airline,
            int price,
            String cabinclass,
            String departureAirportCode,
            String destinationAirportCode,
            String departureDate,
            String arrivalDate
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
