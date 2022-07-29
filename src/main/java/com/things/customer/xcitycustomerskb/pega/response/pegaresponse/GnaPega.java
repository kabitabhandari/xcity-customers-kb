package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GnaPega {
    @JsonProperty("Genres")
    private List<String> Genres;
     @JsonProperty("Actors")
    private List<PegaActor> pegaActors;



}
