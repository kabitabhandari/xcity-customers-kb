package com.things.customer.xcitycustomerskb.provider;

import com.things.customer.xcitycustomerskb.model.NewCustomerDetails;
import com.things.customer.xcitycustomerskb.model.NewCustomerRequestBody;
import com.things.customer.xcitycustomerskb.responsemodel.CustomerDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsProviderTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private CustomerDetailsProvider provider;


    @Test
    void postCustomerUsingWebClientShouldPostSuccessfully() {
        try (MockedStatic<WebClient> webClientMockedStatic = mockStatic(WebClient.class)) {

            webClientMockedStatic.when(WebClient::create).thenReturn(webClient);

            when(webClient.post()).thenReturn(requestBodyUriSpec);

            when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);

            when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.contentType(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.accept(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.body(any(), eq(NewCustomerRequestBody.class))).thenReturn(requestHeadersSpec);

            when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

            when(responseSpec.bodyToMono(NewCustomerDetails.class)).thenReturn(Mono.just(mockedResponseForCreateCustomer()));


            NewCustomerDetails actualResponse = provider.postCustomerUsingWebClient(mockRequestBodyForCreateCustomer());
            Assertions.assertEquals(mockedResponseForCreateCustomer().getEmail(), actualResponse.getEmail(), "Response mis-match");

        }
    }

    @Test
    void post() {
        try (MockedStatic<WebClient> webClientMockedStatic = mockStatic(WebClient.class)) {

            webClientMockedStatic.when(WebClient::create).thenReturn(webClient);

            when(webClient.post()).thenReturn(requestBodyUriSpec);

            when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);

            when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.contentType(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.accept(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);

            when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

            when(responseSpec.bodyToMono(NewCustomerDetails.class))
                    .thenReturn(Mono.just(mockedResponseForCreateCustomer()));


            NewCustomerDetails actualResponse = provider.post();

            Assertions.assertEquals(mockedResponseForCreateCustomer().getEmail(), actualResponse.getEmail(), "Response mis-match");

        }
    }

    @Test
    void displayEachCustomerRecordUsingWebClientShouldGETSuccessfully(){
        try (MockedStatic<WebClient> webClientMockedStatic = mockStatic(WebClient.class)) {

            webClientMockedStatic.when(WebClient::create).thenReturn(webClient);

            when(webClient.get()).thenReturn(requestHeadersUriSpec);

            when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestBodySpec);

            when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.accept(any())).thenReturn(requestBodySpec);

            when(requestBodySpec.retrieve()).thenReturn(responseSpec);

            when(responseSpec.bodyToMono(CustomerDetailsResponse.class))
                    .thenReturn(Mono.just(mockedResponseForGETCustomer()));


            CustomerDetailsResponse actualResponse = provider.displayEachCustomerRecordUsingWebClient("123", "highway");

            Assertions.assertEquals(mockedResponseForGETCustomer().getFirstName(), actualResponse.getFirstName(), "Response mis-match");

        }

    }

    private NewCustomerDetails mockedResponseForCreateCustomer() {
        NewCustomerDetails response = new NewCustomerDetails();
        response.setEmail("edsmith@test.com");
        return response;

    }

    private NewCustomerRequestBody mockRequestBodyForCreateCustomer() {
        NewCustomerRequestBody requestBody = new NewCustomerRequestBody();
        requestBody.setValue1("mock1");
        requestBody.setValue2("mock2");
        return requestBody;
    }

    private CustomerDetailsResponse mockedResponseForGETCustomer() {
        CustomerDetailsResponse response = new CustomerDetailsResponse();
        response.setAge("25");
        response.setFirstName("kabita");
        response.setLastName("bhandari");
        return response;

    }

}