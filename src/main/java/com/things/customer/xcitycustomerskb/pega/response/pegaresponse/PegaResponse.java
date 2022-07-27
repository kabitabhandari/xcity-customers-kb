package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class PegaResponse {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Movies")
    private List<Movie> movies;

}
