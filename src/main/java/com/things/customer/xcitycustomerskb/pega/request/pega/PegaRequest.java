package com.things.customer.xcitycustomerskb.pega.request.pega;

import lombok.Data;

import java.util.List;

@Data
public class PegaRequest {
    private String name;
    private String movieBoard;
    private String channel;
    private List<PlaceholderRequestContext> contexts;
    private String shortMovieID;
    private String MovieID;
    private String zoneID;
    private String shortListedMovieGUID;

}
