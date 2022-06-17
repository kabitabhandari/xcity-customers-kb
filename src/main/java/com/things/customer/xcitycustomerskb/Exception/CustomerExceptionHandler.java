package com.things.customer.xcitycustomerskb.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

@Slf4j
@ControllerAdvice
public class CustomerExceptionHandler {
    private final static String NOT_FOUND_MESSAGE = "Not Found";
    private final static String INTERNAL_SERVER_MESSAGE = "Unhandled exception in service";

    @ExceptionHandler(value = {InvalidException.class})
    public final ResponseEntity<GeneralErrorFormatForPostman> handleInvalidException(Exception ex) {
        log.error("InvalidException: {} {}", ex.getMessage(), ex);
        GeneralErrorFormatForPostman generalErrorFormatForPostman = new GeneralErrorFormatForPostman(NOT_FOUND_MESSAGE, String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(generalErrorFormatForPostman, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {InternalServerException.class})
    public final ResponseEntity<GeneralErrorFormatForPostman> handleInternalServerException(Exception ex) {
        log.error("InternalServerException: {} {}", ex.getMessage(), ex);
        GeneralErrorFormatForPostman generalErrorFormatForPostman = new GeneralErrorFormatForPostman(INTERNAL_SERVER_MESSAGE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(generalErrorFormatForPostman, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {ResourceAccessException.class})
    public final ResponseEntity<GeneralErrorFormatForPostman> handleResourceAccessException(Exception ex) {
        log.error("InternalServerException: {} {}", ex.getMessage(), ex);
        GeneralErrorFormatForPostman generalErrorFormatForPostman = new GeneralErrorFormatForPostman(INTERNAL_SERVER_MESSAGE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(generalErrorFormatForPostman, HttpStatus.valueOf(500));
    }
}
