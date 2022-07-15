package com.things.customer.xcitycustomerskb.model;

import lombok.Data;

@Data
public class Subscriptions {
    private String object;
    private Integer total_count;
    private Boolean has_more;
    private String url;
}
