package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class GnaWrapper {
    private List<WrapperArtist> WrapperArtists;
    private List<String> genres;


}
