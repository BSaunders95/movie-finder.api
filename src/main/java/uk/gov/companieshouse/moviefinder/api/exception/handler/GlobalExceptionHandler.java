package uk.gov.companieshouse.moviefinder.api.exception.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.gov.companieshouse.moviefinder.api.exception.DataNotFoundException;
import uk.gov.companieshouse.moviefinder.api.exception.GenericDataException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> handleDataNotFoundException(Exception ex) {

        logger.error("No data found for request", ex);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericDataException.class)
    protected ResponseEntity<Object> handlerGenericDataException(Exception ex) {

        logger.error("A data exception has occurred", ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {

        logger.error("An exception has occurred", ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
