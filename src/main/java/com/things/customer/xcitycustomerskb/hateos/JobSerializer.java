package com.things.customer.xcitycustomerskb.hateos;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.IOException;

public class JobSerializer implements StreamSerializer<JobDetail> {

    @Override
    public void write(ObjectDataOutput out, JobDetail object) throws IOException {
        out.writeString(object.getState());
        out.writeInt(object.getId());
    }

    @Override
    public JobDetail read(ObjectDataInput in) throws IOException {
        return JobDetail.builder()
                .state(in.readString())
                .id(in.readInt())
                .build();
    }

    @Override
    public int getTypeId() {
        return 1;
    }
}
