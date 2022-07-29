package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PegaDetail {
    @JsonProperty("MovieName")
    private String pictureName;
    @JsonProperty("Year")
    private Integer year;
    @JsonProperty("BoxOfficeID")
    private String boxOfficeID;
    @JsonProperty("ZoneID")
    private String zoneID;
    @JsonProperty("Director")
    private String director;
    @JsonProperty("GenresAndActorList")
    private List<GnaPega> genreNActors;
    @JsonProperty("Direction")
    private String direction;
    private String plot;
    private String posterUrl;
    @JsonProperty("TestID")
    private String testID;
    @JsonProperty("Channel")
    private String channel;
}
