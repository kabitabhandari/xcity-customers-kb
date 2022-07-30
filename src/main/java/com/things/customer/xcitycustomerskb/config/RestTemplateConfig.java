package com.things.customer.xcitycustomerskb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

//@Configuration
public class RestTemplateConfig {
//    @Value("${downstream-services.timeout}")
//    private Long defaultApiTimeout;
//
//    @Bean
//    public RestTemplate myRestTemplate(RestTemplateBuilder restTemplateBuilder) {
//        return buildRestTemplateBuilder(restTemplateBuilder, defaultApiTimeout).build();
//    }
//
//    /*
//    If rest call is taking more than 5s then it will give timeout exception
//     */
//    private RestTemplateBuilder buildRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder, Long defaultApiTimeout) {
//        return restTemplateBuilder.setReadTimeout(Duration.ofSeconds(defaultApiTimeout));
//    }

}
