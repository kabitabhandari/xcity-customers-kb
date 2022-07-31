package com.things.customer.xcitycustomerskb.pega.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.things.customer.xcitycustomerskb.pega.request.wrapper.WrapperRequest;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility {
    private final ObjectMapper objectMapper;

    public MappingUtility(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public WrapperRequest mapStringToCreateWrapperRequest(String stringRequestFromPostman) {
        WrapperRequest outgoingObject = null;

        try {
            outgoingObject = objectMapper.readValue(stringRequestFromPostman, WrapperRequest.class);
        } catch (JsonProcessingException ex) {
            ex.getMessage();
        }
        return outgoingObject;
    }
}
