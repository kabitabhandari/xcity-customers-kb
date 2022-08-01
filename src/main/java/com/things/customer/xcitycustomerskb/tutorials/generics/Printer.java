package com.things.customer.xcitycustomerskb.tutorials.generics;

public class Printer<T> {

    T printThis;

    public Printer(T printThis) {
        this.printThis = printThis;
    }

    public void print(){
        System.out.println(printThis);
    }
}
