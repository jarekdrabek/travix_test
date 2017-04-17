package drabek.jaroslaw.supplier.toughjet;

public class TaughJetResponseDTO {
    private String carrier;
    private String basePrice;
    private String tax;
    private String discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private int departureDay;
    private int departureMonth;
    private int departureYear;
    private int returnDay;
    private int returnMonth;
    private int returnYear;

    public TaughJetResponseDTO() {
    }

    public String getCarrier() {
        return carrier;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getTax() {
        return tax;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }
}
