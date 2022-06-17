package com.things.customer.xcitycustomerskb.Exception;

public class GeneralErrorFormatForPostman {
    private String message;
    private String code;

    public GeneralErrorFormatForPostman() {
    }

    public GeneralErrorFormatForPostman(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
