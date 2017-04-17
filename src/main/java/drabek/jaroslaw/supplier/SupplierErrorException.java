package drabek.jaroslaw.supplier;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class SupplierErrorException extends HttpServerErrorException {

    public SupplierErrorException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
