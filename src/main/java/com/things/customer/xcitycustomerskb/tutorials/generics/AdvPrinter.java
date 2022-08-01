package com.things.customer.xcitycustomerskb.tutorials.generics;

public class AdvPrinter<T extends Animal> {  // bounded generic
    T printThis;

    public AdvPrinter(T printThis) {
        this.printThis = printThis;
    }

    public void printAdvance(){
        System.out.println(printThis);
    }
}
