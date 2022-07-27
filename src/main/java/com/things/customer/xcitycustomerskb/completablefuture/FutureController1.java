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
import java.util.stream.Collectors;


/**

 Thread name for type 1 in controller ==> http-nio-8080-exec-3
 Thread name for async annotation in service class with @Async annotation ==> task-1
 Thread name for async annotation  in service class with @Async annotation ==> task-1


 Thread name for non-async annotation outside thread pool==> http-nio-8080-exec-5
 Thread name for non-async annotation in controller ==> http-nio-8080-exec-5
 Thread name for non-async annotation INSIDE thread pool==> pool-1-thread-1

 */







@RestController
public class FutureController1 {
    private final String GET_CUSTOMER_DETAILS = "v1/all";
    private final CustomerDetailsService customerDetailsService;
    private final AsyncService1 asyncService1;

    public FutureController1(CustomerDetailsService customerDetailsService, AsyncService1 asyncService1) {
        this.customerDetailsService = customerDetailsService;
        this.asyncService1 = asyncService1;
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
        //completable future
        System.out.println("Thread name for type 1 in controller ==> " + Thread.currentThread().getName());

        CompletableFuture<List<CustomerDetailsResponse>> completableFutureList = asyncService1.getAllDetails(memberChannel);


        //joining all futures when async service is complete
        CompletableFuture.allOf(completableFutureList).join();



        //Use get() method to get all the lists from completable future
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
