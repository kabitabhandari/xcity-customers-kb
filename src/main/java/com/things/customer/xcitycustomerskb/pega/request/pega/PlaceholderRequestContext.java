package com.things.customer.xcitycustomerskb.pega.request.pega;

import lombok.Data;

@Data
public class PlaceholderRequestContext {
    private String type;
    private String key;
    private String value;

    @Override
    public String toString() {
        return "GaapRequestContext{" +
                "type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
