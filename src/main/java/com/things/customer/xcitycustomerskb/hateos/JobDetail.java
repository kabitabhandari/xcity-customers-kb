package com.things.customer.xcitycustomerskb.hateos;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class JobDetail extends RepresentationModel<JobDetail> {
    private String state;
    private Integer id;

    public JobDetail(Integer id, String state) {
        this.state = state;
        this.id = id;
    }

    public enum JobState {
        PROCESSING, COMPLETED, FAILED
    }


}
