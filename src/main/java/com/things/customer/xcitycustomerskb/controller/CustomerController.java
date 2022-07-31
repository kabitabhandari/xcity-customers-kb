package com.things.customer.xcitycustomerskb.controller;

import com.things.customer.xcitycustomerskb.Exception.InvalidException;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerRequestBody;
import com.things.customer.xcitycustomerskb.service.CustomerDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private static final String GET_SONGS = "v1/songs";
    private final String GET_CUSTOMER_DETAILS = "v1/mps/knowing/customers";
    private final String GET_EACH_CUSTOMER_DETAILS = "v1/mps/knowing/customer/{id}/details";
    private final String CREATE_NEW_CUSTOMER = "v1/mps/knowing/customer/create";
    private final CustomerDetailsService customerDetailsService;

    public CustomerController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    /**
     * @param memberChannel
     * @return
     * @throws Exception
     */
    @GetMapping(path = GET_CUSTOMER_DETAILS)
    public List<CustomerDetails> getCustomers(@RequestHeader(value = "channel") String memberChannel) throws Exception {
        if (!customerDetailsService.isValidMemberChannel(memberChannel)) {
            throw new InvalidException("Member Channel is invalid");
        }
        List<CustomerDetails> response = customerDetailsService.getAllDetails(memberChannel);
        return response;
    }

    /**
     * @param memberChannel
     * @param customerId
     * @return
     */
    @GetMapping(path = GET_EACH_CUSTOMER_DETAILS)
    public CustomerDetails getEachCustomer(@RequestHeader(value = "channel") String memberChannel,
                                           @PathVariable("id") String customerId) {
        if (!customerDetailsService.isValidMemberChannel(memberChannel)) {
            throw new InvalidException("Member Channel is invalid");
        }
        CustomerDetails response = customerDetailsService.getEachDetails(customerId, memberChannel);
        return response;
    }

    /**
     * Gives the song by Denver..!
     *
     * @return String
     */
    @GetMapping(path = GET_SONGS)
    public String getFavouriteSong() {
        return customerDetailsService.getDenverSong();
    }

    /**
     * Posts a new customer id and meta data in the system
     *
     * @return String
     */
    @PostMapping(path = CREATE_NEW_CUSTOMER)
    public ResponseEntity<NewCustomerDetails> postNewCustomer(@RequestBody NewCustomerRequestBody requestBody) {
        return customerDetailsService.getNew(requestBody);
    }


}
