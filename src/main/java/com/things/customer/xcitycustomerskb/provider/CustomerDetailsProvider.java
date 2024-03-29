package com.things.customer.xcitycustomerskb.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.things.customer.xcitycustomerskb.Exception.InternalServerException;
import com.things.customer.xcitycustomerskb.config.RestTemplateConfig;
import com.things.customer.xcitycustomerskb.model.ModelForCustomerCareUnit;
import com.things.customer.xcitycustomerskb.model.NewCustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerRequestBody;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CustomerDetailsProvider {
    private static final String GET_ALL_CUSTOMERS_CONTEXT = "/all-customers-details";
    private static final String GET_EACH_CUSTOMERS_CONTEXT = "/cust/"; //TODO do we need slash here??
    private static final String POST_NEW_CUSTOMER_CONTEXT = "/cust/new";
    private static final String DETAILS = "/details";
    private final String MOCK_BASE_URL;
    private final RestTemplateConfig restTemplate;

    public CustomerDetailsProvider(
            @Value("${mockserver_base_url}") String MockserverBaseUrl,
            RestTemplateConfig restTemplate) {
        this.MOCK_BASE_URL = MockserverBaseUrl;
        this.restTemplate = restTemplate;
    }

    /**
     * Get Customer Details from mock server rest call
     *
     * @param memberChannel
     * @return List<CustomerDetailsRequest>
     */
    public List<CustomerDetailsResponse> getAllDetailsResponse(String memberChannel) {
        String url = buildUrlForGetAllCustomers().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("channel", memberChannel);

        // TODO  HttpEntity<String> is used because we have only headers in request and no any request body.
        //  If there was a body we would have used  HttpEntity<RequestModelClass>
        HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<CustomerDetailsResponse[]> response =
                restTemplate.myRestTemplate(new RestTemplateBuilder()).exchange(url, HttpMethod.GET, requestEntity, CustomerDetailsResponse[].class);
        log.info("Successfully Invoked Mock Server");

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new InternalServerException("Response status code" + response.getStatusCode() + " " + "received from server for ");
        }
        //serialization allows us to convert the state of an object into a byte stream,
        // which then can be saved into a file on the local disk or sent over the network to any other machine
        serializeResponseForWireProcess(response);

        // Sending customized response to CustomerCareUnit
        UpdatedResponseObjectForCustomerCareUnit(response);


        return Arrays.asList(response.getBody());
    }

    public CustomerDetailsResponse displayEachCustomerRecord(String customerId, String memberChannel) {
        String url = buildUrlForGetEachCustomer(customerId).toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("channel", memberChannel);

        HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<CustomerDetailsResponse> response =
                restTemplate.myRestTemplate(new RestTemplateBuilder()).exchange(url, HttpMethod.GET, requestEntity, CustomerDetailsResponse.class);
        log.info("Successfully Invoked Mock Server");

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new InternalServerException("Response status code" + response.getStatusCode() + " " + "received from server for ");
        }
        return response.getBody();


    }

    public ResponseEntity<NewCustomerDetails> postCustomer(NewCustomerRequestBody requestBody){
        String url = buildUrlForPostCustomer().toUriString();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<NewCustomerRequestBody> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<NewCustomerDetails> response =
                restTemplate.myRestTemplate(new RestTemplateBuilder()).postForEntity(url, requestEntity,  NewCustomerDetails.class);
        return response;


    }


    /**
     * UpdatedResponseObjectForCustomerCareUnit accepts the whole list[] from response entity and does stream on it and
     * map to our model class ModelForCustomerCareUnit using map().when mapping is completed, it now converts it to list and returns result back.
     *
     * @param response
     */
    private List<ModelForCustomerCareUnit> UpdatedResponseObjectForCustomerCareUnit(ResponseEntity<CustomerDetailsResponse[]> response) {
        return Arrays.stream(response.getBody()).map(m -> mappingFunction(m)).collect(Collectors.toList());

    }

    /**
     * For customer care unit, they needed customised data fields from actual response as below
     *
     * @param response
     * @return
     */
    private ModelForCustomerCareUnit mappingFunction(CustomerDetailsResponse response) {
        ModelForCustomerCareUnit customerCareUnit = new ModelForCustomerCareUnit();
        customerCareUnit.setFullName(response.getFirstName() + " " + response.getLastName());
        customerCareUnit.setAge(response.getAge());
        customerCareUnit.setAddress(response.getAddress().getStreetAddress() + "  " + response.getAddress().getState());
        customerCareUnit.setPhoneNumber(response.getPhoneNumber().get(0).getNumber());
        //System.out.println(customerCareUnit);
        return customerCareUnit;
    }


    /**
     * Builds part of url for customer details
     *
     * @return UriComponents
     */
    private UriComponents buildUrlForGetAllCustomers() {
        return UriComponentsBuilder.newInstance().scheme("http").host(MOCK_BASE_URL).path(GET_ALL_CUSTOMERS_CONTEXT).build();
    }

    private UriComponents buildUrlForGetEachCustomer(String customerId) {
        return UriComponentsBuilder.newInstance().scheme("http").host(MOCK_BASE_URL).path(GET_EACH_CUSTOMERS_CONTEXT).path(customerId).path(DETAILS).build();
    }


    private UriComponents buildUrlForPostCustomer() {
        return UriComponentsBuilder.newInstance().scheme("http").host(MOCK_BASE_URL).path(POST_NEW_CUSTOMER_CONTEXT).build();
    }



    /**
     * gives json string out of response 'serialization'
     *
     * @param response
     */
    private void serializeResponseForWireProcess(ResponseEntity<CustomerDetailsResponse[]> response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("objectmapper = "+ objectMapper);
            String d = objectMapper.writeValueAsString(response.getBody());
            System.out.println("json of response object >>> " + d);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }
    }
}
