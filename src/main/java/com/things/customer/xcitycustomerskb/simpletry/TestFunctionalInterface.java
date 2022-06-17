package com.things.customer.xcitycustomerskb.simpletry;
public class TestFunctionalInterface {
    public static void main(String... args) {
        //implementing any interface that is not a functional interface:
        SomeInterface si1 = new SomeInterface() {
            @Override
            public void m1() {
                System.out.println("non functional interface implementation part 1");

            }

            @Override
            public void m4() {
                System.out.println("non functional interface implementation part 2");

            }
        };

        // implementing functional interface old approach

        FunctionalInterfaceKB fi1 = new FunctionalInterfaceKB() {
            @Override
            public void disp() {
                System.out.println("I am from functional interface >>> ");
            }
        };


        // implementing functional interface in functional approach:

        FunctionalInterfaceKB fi2 = () -> {
            System.out.println("I am from lamda implementation");
        };



        fi1.disp();
        fi2.disp();
        si1.m1();
        si1.m2();
        si1.m4();

    }
}
