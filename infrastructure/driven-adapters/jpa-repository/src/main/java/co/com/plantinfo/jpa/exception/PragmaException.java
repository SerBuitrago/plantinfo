package co.com.plantinfo.jpa.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PragmaException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;


    public PragmaException(String message) {
        this(HttpStatus.NOT_FOUND, message);
    }

    public PragmaException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
