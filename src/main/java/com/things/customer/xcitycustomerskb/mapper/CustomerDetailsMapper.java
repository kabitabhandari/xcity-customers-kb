package com.things.customer.xcitycustomerskb.mapper;

import com.things.customer.xcitycustomerskb.model.Address;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.model.PhoneNumber;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// when all the responses is parsed fully
//when only part of responses is to be parsed


@Component
public class CustomerDetailsMapper {

    // Method 01: mapping response to model class using stream

    /**
     * Map CustomerDetailsRequest list to CustomerDetailsRequest list
     *
     * @param response
     * @return List<CustomerDetailsRequest>
     */
    public List<CustomerDetails> mapCustomerDetailsToCustomer(List<CustomerDetailsResponse> response) {
        return response.stream()
                .map(m -> (mapCustomerDetailsFromServiceCallToModel(m)))
                .collect(Collectors.toList());
    }


    /**
     * Map CustomerDetailsRequest
     *
     * @param response
     * @return CustomerDetailsRequest
     */
    public CustomerDetails mapCustomerDetailsFromServiceCallToModel(CustomerDetailsResponse response) {
        CustomerDetails customerDetails = new CustomerDetails();

        customerDetails.setFirstName(response.getFirstName());
        customerDetails.setLastName(response.getLastName());
        customerDetails.setAge(response.getAge());

        Address address = new Address();
        address.setStreetAddress(response.getAddress().getStreetAddress());
        address.setState(response.getAddress().getState());
        customerDetails.setAddress(address);

        List<PhoneNumber> listOfPhone = new ArrayList<>();
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(response.getPhoneNumber().get(0).getNumber());
        phoneNumber.setType(response.getPhoneNumber().get(0).getType());
        listOfPhone.add(phoneNumber);
        customerDetails.setPhoneNumber(listOfPhone);

        return customerDetails;
    }



    /*Alternative method 2 : not using stream
     *
     *
     */

    /*
    public List<CustomerDetailsGrp1Request> mapCustomerDetailsToCustomer(List<CustomerDetailsGrp1Request> response) {
        List<CustomerDetailsGrp1Request> array1 = new ArrayList<>();
       for( CustomerDetailsGrp1Request r : response){
           CustomerDetailsGrp1Request result = mapCustomerDetailsFromServiceCallToModel(r);
           array1.add(result);
       }
       return array1;
    }


    private CustomerDetailsGrp1Request mapCustomerDetailsFromServiceCallToModel(CustomerDetailsGrp1Request response) {
        CustomerDetailsGrp1Request customerDetailsGrP1Request = new CustomerDetailsGrp1Request();
        customerDetailsGrP1Request.setFirstName(response.getFirstName());
        customerDetailsGrP1Request.setLastName(response.getLastName());
        customerDetailsGrP1Request.setAge(response.getAge());
        customerDetailsGrP1Request.setAddress(response.getAddress());
        customerDetailsGrP1Request.setPhoneNumber(response.getPhoneNumber());

        Address address = new Address();
        address.setStreetAddress(response.getAddress().getStreetAddress());
        address.setCity(response.getAddress().getCity());
        address.setState(response.getAddress().getState());
        address.setPostalCode(address.getPostalCode());

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(response.getPhoneNumber().get(0).getNumber());
        phoneNumber.setNumber(response.getPhoneNumber().get(0).getType());

        return customerDetailsGrP1Request;

    }
*/


}
