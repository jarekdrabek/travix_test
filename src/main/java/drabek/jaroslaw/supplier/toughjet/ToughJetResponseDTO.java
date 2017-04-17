package drabek.jaroslaw.supplier.toughjet;

public class ToughJetResponseDTO {
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

    public ToughJetResponseDTO() {
    }

    public ToughJetResponseDTO(String carrier, String basePrice, String tax, String discount, String departureAirportName, String arrivalAirportName, int departureDay, int departureMonth, int departureYear, int returnDay, int returnMonth, int returnYear) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.departureDay = departureDay;
        this.departureMonth = departureMonth;
        this.departureYear = departureYear;
        this.returnDay = returnDay;
        this.returnMonth = returnMonth;
        this.returnYear = returnYear;
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
