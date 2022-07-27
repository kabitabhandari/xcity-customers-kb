package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class ShortlistedMovie {
    private String banner;
    private List<PictureInfo> pictureInfos;
}
