package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class SelectedMovieDetails {
    private String movieName;
    private Integer releasedYear;
    private List<GA> genreNActors;
    private String plotGlance;

}
