package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.mapper.CustomerDetailsMapper;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.provider.CustomerDetailsProvider;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import com.things.customer.xcitycustomerskb.util.Constants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDetailsService {
    private final CustomerDetailsProvider customerDetailsProvider;
    private final CustomerDetailsMapper customerDetailsMapper;

    public CustomerDetailsService(CustomerDetailsProvider customerDetailsProvider, CustomerDetailsMapper customerDetailsMapper) {
        this.customerDetailsProvider = customerDetailsProvider;
        this.customerDetailsMapper = customerDetailsMapper;
    }

    public List<CustomerDetails> getAllDetails(String memberChannel) {
        List<CustomerDetailsResponse> response = customerDetailsProvider.getAllDetailsResponse(memberChannel);
        return customerDetailsMapper.mapCustomerDetailsToCustomer(response);
    }

    public boolean isValidMemberChannel(String memberChannel) {
        return memberChannel.toUpperCase().matches(Constants.REGEX_VALID_CHANNEL);
    }

    public CustomerDetails getEachDetails(String customerId, String memberChannel) {
        CustomerDetailsResponse response = customerDetailsProvider.displayEachCustomerRecord(customerId, memberChannel);
        return customerDetailsMapper.mapCustomerDetailsFromServiceCallToModel(response);
    }

    public String getDenverSong() {
        return "country roads, Take me home to the place I belong.\n" +
                "West Virginia, Mountain momma, take me home, Country roads";
    }
}
