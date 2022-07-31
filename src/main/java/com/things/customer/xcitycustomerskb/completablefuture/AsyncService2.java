package com.things.customer.xcitycustomerskb.completablefuture;

import com.things.customer.xcitycustomerskb.Exception.InternalServerException;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class AsyncService2 {
    private static final String GET_ALL_CUSTOMERS_CONTEXT = "/all-customers-details";
    private final String MOCK_BASE_URL;
    private final RestTemplate restTemplate;

    public AsyncService2(@Value("${mockserver_base_url}") String mock_base_url,
                         @Qualifier("general") RestTemplate restTemplate) {
        MOCK_BASE_URL = mock_base_url;
        this.restTemplate = restTemplate;
    }

    public CompletableFuture<List<CustomerDetailsResponse>> getAllDetails(String memberChannel) throws InterruptedException {
        CompletableFuture<List<CustomerDetailsResponse>> completableFuture = new CompletableFuture<>();
        System.out.println("Thread name for non-async annotation outside thread pool==> " + Thread.currentThread().getName());
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);

            String url = buildUrlForGetAllCustomers().toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.set("channel", memberChannel);
            HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);
            ResponseEntity<CustomerDetailsResponse[]> response =
                    restTemplate.exchange(url, HttpMethod.GET, requestEntity, CustomerDetailsResponse[].class);
            log.info("Successfully Invoked Mock Server");

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new InternalServerException("Response status code" + response.getStatusCode() + " " + "received from server for ");
            }

            completableFuture.complete(Arrays.asList(response.getBody()));
            System.out.println("Thread name for non-async annotation INSIDE thread pool==> " + Thread.currentThread().getName());


            return null;

        });
        return completableFuture;

    }

    /**
     * Builds part of url for customer details
     *
     * @return UriComponents
     */
    private UriComponents buildUrlForGetAllCustomers() {
        return UriComponentsBuilder.newInstance().scheme("http").host(MOCK_BASE_URL).path(GET_ALL_CUSTOMERS_CONTEXT).build();
    }
}
