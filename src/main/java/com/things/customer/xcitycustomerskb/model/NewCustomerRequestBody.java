package com.things.customer.xcitycustomerskb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCustomerRequestBody {
    private String value1;
    private String value2;
}
