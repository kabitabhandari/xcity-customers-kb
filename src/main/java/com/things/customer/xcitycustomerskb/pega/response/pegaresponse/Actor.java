package com.things.customer.xcitycustomerskb.pega.response.pegaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;




@Data
public class Actor {
    @JsonProperty("MaleLeadActor")
    private String maleLeadActor;

    @JsonProperty("FemaleLeadActor")
    private String femaleLeadActor;

    @JsonProperty("Rating")
    private Integer vote;


}
