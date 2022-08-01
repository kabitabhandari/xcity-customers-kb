package com.things.customer.xcitycustomerskb.generics;

import java.util.Objects;

public class Printer<T> {

    T printThis;

    public Printer(T printThis) {
        this.printThis = printThis;
    }

    public void print(){
        System.out.println(printThis);
    }
}
