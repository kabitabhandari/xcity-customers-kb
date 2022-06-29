package com.things.customer.xcitycustomerskb.controller;

import com.things.customer.xcitycustomerskb.Exception.InvalidException;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.service.CustomerDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private static final String GET_SONGS = "v1/songs" ;
    private final String GET_CUSTOMER_DETAILS = "v1/mps/knowing/customers";
    private final String GET_EACH_CUSTOMER_DETAILS = "v1/mps/knowing/customer/{customer-id}/details";
    private final CustomerDetailsService customerDetailsService;

    public CustomerController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping(path = GET_CUSTOMER_DETAILS)
    public List<CustomerDetails> getCustomers(@RequestHeader(value = "channel") String memberChannel) throws Exception {
        if (!customerDetailsService.isValidMemberChannel(memberChannel)) {
            throw new InvalidException("Member Channel is invalid");
        }
        List<CustomerDetails> response = customerDetailsService.getAllDetails(memberChannel);
        return response;
    }

    @GetMapping(path = GET_EACH_CUSTOMER_DETAILS)
    public CustomerDetails getEachCustomer(@RequestHeader(value = "channel") String memberChannel,
                                           @PathVariable("customer-id") String customerId) {
        if (!customerDetailsService.isValidMemberChannel(memberChannel)) {
            throw new InvalidException("Member Channel is invalid");
        }
        CustomerDetails response = customerDetailsService.getEachDetails(customerId, memberChannel);
        return response;
    }

    @GetMapping(path = GET_SONGS)
    public String getFavouriteSong() {
        return customerDetailsService.getDenverSong();
    }
}
