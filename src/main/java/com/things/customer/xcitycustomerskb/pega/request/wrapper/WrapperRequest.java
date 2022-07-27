package com.things.customer.xcitycustomerskb.pega.request.wrapper;

import com.things.customer.xcitycustomerskb.pega.request.pega.PlaceholderRequestContext;
import lombok.Data;

import java.util.List;

@Data
public class WrapperRequest {
    //L8-15 comes from request body payload
    private String name;
    private String movieBoard;
    private String channel;
    private List<PlaceholderRequestContext> contexts;
    private String shortMovieID;
    private String movieID;
    private String zoneIDs;
    private String shortListedMovieGUID;
    // request body validation by doing @NotNull(message="Zone Ids missing or empty") won't work in our case because our request body is received as a string.
    // It had to be in a model type to use @NotNull. eg. @Valid @RequestBody String stringRequestFromPostman  instead of this, if it was  @Valid @RequestBody CreateInteractionRequest stringRequestFromPostman

    private String someOtherId;
    private String generatedID;  //xdc

}
