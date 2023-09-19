package nl.cjib.eventsourcing.api;

import nl.cjib.eventsourcing.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FinancieleVerplichtingExceptionHandlers {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFouncException(NotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
    }
}
