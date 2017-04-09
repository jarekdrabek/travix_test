package drabek.jaroslaw;

import com.google.common.base.Preconditions;

import java.io.Serializable;

public class IATACode implements Serializable {
    String code;

    public static IATACode of(String code){
        return new IATACode(code);
    }

    private IATACode(String code) {
        Preconditions.checkArgument(isValidCode(code), "'%s' is not a valid IATA code.");
        this.code = code;
    }

    private static boolean isValidCode(String code) {
        return code.length()==3;
    }

    @Override
    public String toString() {
        return code;
    }
}
