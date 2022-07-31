package com.things.customer.xcitycustomerskb.service;

import com.things.customer.xcitycustomerskb.beanpackage.MyOwnedBeans;
import com.things.customer.xcitycustomerskb.mapper.CustomerDetailsMapper;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerRequestBody;
import com.things.customer.xcitycustomerskb.provider.CustomerDetailsProvider;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import com.things.customer.xcitycustomerskb.util.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDetailsService {

    private final CustomerDetailsProvider customerDetailsProvider;
    private final CustomerDetailsMapper customerDetailsMapper;
    private final MyOwnedBeans myOwnedBeans;
    @Value("${max_retry_attempts_to_call_pega}")  // @value could be put in constructor to look clean
    private Integer max_retry_2;
    private final int max_retry;

    public CustomerDetailsService(
            CustomerDetailsProvider customerDetailsProvider,
            CustomerDetailsMapper customerDetailsMapper,
            @Value("${max_retry_attempts_to_call_pega}") int a1, MyOwnedBeans myOwnedBeans) {
        this.customerDetailsProvider = customerDetailsProvider;
        this.customerDetailsMapper = customerDetailsMapper;
        this.max_retry = a1;

        this.myOwnedBeans = myOwnedBeans;
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
        System.out.println("MAX_RETRY_ATTEMPTS  " + max_retry);
        System.out.println("MAX_RETRY_ATTEMPTS2  " + max_retry_2);
        System.out.println(myOwnedBeans.answer());

        return "country roads, Take me home to the place I belong.\n" +
                "West Virginia, Mountain momma, take me home, Country roads";
    }

    public ResponseEntity<NewCustomerDetails> getNew(NewCustomerRequestBody requestBody) {
        ResponseEntity<NewCustomerDetails> response = customerDetailsProvider.postCustomer(requestBody);
        return response;
    }
}
