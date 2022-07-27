package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class ShortlistedMoviesForWrapper {
    private String bigIndustry;
    private List<SelectedMovieDetails> selectedMovieDetails;
}
