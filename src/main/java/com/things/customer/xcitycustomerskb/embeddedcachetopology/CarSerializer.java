package com.things.customer.xcitycustomerskb.embeddedcachetopology;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.IOException;

public class CarSerializer implements StreamSerializer<Car> {

    @Override
    public void write(ObjectDataOutput out, Car object) throws IOException {
        out.writeString(object.getName());
        out.writeString(object.getNumber());
    }

    @Override
    public Car read(ObjectDataInput in) throws IOException {
        return Car.builder()
                .name(in.readString())
                .number(in.readString())
                .build();
    }

    @Override
    public int getTypeId() {
        return 1;
    }
}
