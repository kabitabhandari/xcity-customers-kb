package com.things.customer.xcitycustomerskb.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NewCustomerDetails {
    private String id;
    private String object;
    private Date created;
    private Boolean livemode;
    private String description;
    private String email;
    private Boolean delinquent;
    private Subscriptions subscriptions;
    private BigDecimal discount;
    private BigDecimal account_balance;
    private String currency;
    private String default_card;
}
