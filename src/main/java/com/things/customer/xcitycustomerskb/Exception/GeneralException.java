package com.things.customer.xcitycustomerskb.Exception;

import lombok.Data;

@Data
public class GeneralException extends RuntimeException {
    //TODO add serival version uid

    private int status;

    public GeneralException(String message) {

        super(message);
    }

    public GeneralException(Exception e) {
        super(e);
    }
    public GeneralException(String message, Exception e) {
        super(message, e);
    }

    public GeneralException(int status, String message) {
        super(message);
        this.status = status;
    }
    public GeneralException(int status, String message, Exception e) {
        super(message, e);
        this.status = status;
    }



}
