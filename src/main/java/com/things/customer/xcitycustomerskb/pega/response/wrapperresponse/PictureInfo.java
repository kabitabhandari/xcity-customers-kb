package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import com.things.customer.xcitycustomerskb.pega.response.pegaresponse.GnaPega;
import lombok.Data;

import java.util.List;

@Data
public class PictureInfo {
    private String movieName;
    private Integer releasedYear;
    private List<GnA> genreNActors;
    private String plotGlance;

}
