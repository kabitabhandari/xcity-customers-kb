package com.things.customer.xcitycustomerskb.pega.response.wrapperresponse;

import lombok.Data;

import java.util.List;

@Data
public class WrapperMovie {
    private List<WrapperDetail> wrapperDetails;
    private String bigIndustry;
}
