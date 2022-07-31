package com.things.customer.xcitycustomerskb.beanpackage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class MyOwnedBeans {

    @Value("${a}")
    private Integer a;

    @Value("${b}")
    private Integer b;

    @Bean
    public BigDecimal answer() {
        return new BigDecimal(a + b);
    }


}
