package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class WrapperDetail {
    private List<GnaWrapper> genreNActors;
    private String movieName;
    private Integer releasedYear;
    private String plotGlance;

}
