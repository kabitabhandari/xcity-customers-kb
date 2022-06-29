package com.things.customer.xcitycustomerskb.Exception;

public class PostmanFormat {
    private String message;
    private String code;

    public PostmanFormat() {
    }

    public PostmanFormat(String message, String code) {
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
