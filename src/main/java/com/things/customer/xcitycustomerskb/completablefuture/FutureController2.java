package com.things.customer.xcitycustomerskb.completablefuture;

import com.things.customer.xcitycustomerskb.Exception.InvalidException;
import com.things.customer.xcitycustomerskb.model.Address;
import com.things.customer.xcitycustomerskb.model.CustomerDetails;
import com.things.customer.xcitycustomerskb.model.PhoneNumber;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import com.things.customer.xcitycustomerskb.service.CustomerDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

    @RestController
    public class FutureController2 {
        private final String GET_CUSTOMER_DETAILS = "v2/all";
        private final CustomerDetailsService customerDetailsService;
        private final AsyncService2 asyncService2;

        public FutureController2(CustomerDetailsService customerDetailsService, AsyncService2 asyncService) {
            this.customerDetailsService = customerDetailsService;
            this.asyncService2 = asyncService;
        }

        @GetMapping(path = GET_CUSTOMER_DETAILS)
        public List<CustomerDetails> getCustomers(@RequestHeader(value = "channel") String memberChannel) throws Exception {
            if (!customerDetailsService.isValidMemberChannel(memberChannel)) {
                throw new InvalidException("Member Channel is invalid");
            }
            List<CustomerDetailsResponse> response = getAllDetailsResponse(memberChannel);
            return mapCustomerDetailsToCustomer(response);
        }

        public List<CustomerDetailsResponse> getAllDetailsResponse(String memberChannel) throws ExecutionException, InterruptedException {
            CompletableFuture<List<CustomerDetailsResponse>> completableFutureList = asyncService2.getAllDetails(memberChannel);
            System.out.println("Thread name for non-async annotation in controller ==> " + Thread.currentThread().getName());

            CompletableFuture.allOf(completableFutureList).join();
            List<CustomerDetailsResponse> resultList = completableFutureList.get();
            return resultList;
        }


        public List<CustomerDetails> mapCustomerDetailsToCustomer(List<CustomerDetailsResponse> response) {
            return response.stream()
                    .map(m -> (mapCustomerDetailsFromServiceCallToModel(m)))
                    .collect(Collectors.toList());
        }


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
}
