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
    private final static String MAP_IS_EMPTY_MESSAGE = "Map is empty";
    private final static String INTERNAL_SERVER_MESSAGE = "Unhandled exception in service123";
    private final static String TIMEOUT_MESSAGE = "Timeout in service call";

    @ExceptionHandler(value = {InvalidException.class})
    public final ResponseEntity<PostmanFormat> handleInvalidException(Exception ex) {
        log.error("InvalidException: {} {}", ex.getMessage(), ex);
        PostmanFormat postmanFormat = new PostmanFormat(NOT_FOUND_MESSAGE, String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(postmanFormat, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {InternalServerException.class})
    public final ResponseEntity<PostmanFormat> handleInternalServerException(Exception ex) {
        log.error("InternalServerException: {} {}", ex.getMessage(), ex);
        PostmanFormat postmanFormat = new PostmanFormat(INTERNAL_SERVER_MESSAGE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(postmanFormat, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ResourceAccessException.class})
    public final ResponseEntity<PostmanFormat> handleResourceAccessException(Exception ex) {
        log.error("InternalServerException: {} {}", ex.getMessage(), ex);
        PostmanFormat postmanFormat = new PostmanFormat(TIMEOUT_MESSAGE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(postmanFormat, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(value = {MapIsEmptyException.class})
    public final ResponseEntity<PostmanFormat> handleMapIsEmptyException(Exception ex) {
        log.error("MapIsEmptyException: {} {}", ex.getMessage(), ex);
        PostmanFormat postmanFormat = new PostmanFormat(MAP_IS_EMPTY_MESSAGE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(postmanFormat, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(value = {GeneralException.class})
    public final ResponseEntity<PostmanFormat> handleGeneralException(GeneralException ex) {
        Integer status = ex.getStatus();
        log.error("GeneralException: {} {}", ex.getMessage(), ex);
        PostmanFormat postmanFormat = new PostmanFormat(ex.getMessage(), status.toString());
        return new ResponseEntity<>(postmanFormat, HttpStatus.valueOf(400));
    }

}
