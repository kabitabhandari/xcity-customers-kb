package com.things.customer.xcitycustomerskb.simpletry;


public interface SomeInterface {
    void m1();
    default void m2(){
        System.out.println("hi hi hi");

    };

    static void m3(){

    }

    void m4();

}
