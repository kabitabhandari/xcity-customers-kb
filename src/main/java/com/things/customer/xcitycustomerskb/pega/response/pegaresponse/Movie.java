package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Movie {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("IndustryName")
    private String industryName;
    @JsonProperty("Details")
    private List<Detail> details;
}
