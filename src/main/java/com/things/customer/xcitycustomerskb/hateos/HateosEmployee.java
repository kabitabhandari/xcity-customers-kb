package com.things.customer.xcitycustomerskb.hateos;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
/**
 * The Employee resource extends from the RepresentationModel class to inherit the add() method.
 * So once we create a link, we can easily set that value to the resource representation without adding any new fields to it.
 */
public class HateosEmployee extends RepresentationModel<HateosEmployee> {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private JobDetail status;
}
