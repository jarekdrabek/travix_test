package drabek.jaroslaw.supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

public class SupplierErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        switch (statusCode.series()) {
            case SERVER_ERROR:
                throw new SupplierErrorException(statusCode, response.getStatusText());
            default:
                throw new RestClientException("Unknown status code [" + statusCode + "]");
        }
    }
}
