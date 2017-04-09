package drabek.jaroslaw;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Flight2 implements Serializable{
    LocalDateTime date;
    BigDecimal fare;
    IATACode code;


    @JsonCreator
    public Flight2(
            @JsonProperty("date") LocalDateTime date,
            @JsonProperty("fare") BigDecimal fare,
            @JsonProperty("fare") IATACode code
    ) {
        this.date = date;
        this.fare = fare;
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public IATACode getCode() {
        return code;
    }
}
