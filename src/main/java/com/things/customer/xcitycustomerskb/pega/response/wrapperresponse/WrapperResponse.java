package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class WrapperResponse {
    private String boxOfficeID;
    private List<ShortlistedMovie> shortlistedMovies;
}
