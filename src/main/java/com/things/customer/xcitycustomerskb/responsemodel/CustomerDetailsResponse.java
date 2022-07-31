package com.things.customer.xcitycustomerskb.responsemodel;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CustomerDetailsResponse implements Serializable {
    //TODO put correct one
    //private static final long serialeVersionUID = 1;
    private String firstName;
    private String lastName;
    private String age;
    private Address address;
    private List<PhoneNumber> phoneNumber;
}
