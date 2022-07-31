package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PegaResponse {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("BoxOfficeID")
    private String boxOfficeID;
    @JsonProperty("Movies")
    private List<PegaMovie> pegaMovies;

}
