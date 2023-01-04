package com.things.customer.xcitycustomerskb.learnlambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class WhyLamda {
    public static void main(String[] args) {

// new class needed if you want to add a new function
        Output o = new Output();
        int result = o.additionIs(10,5);
        System.out.println("result is " + result);

        /**
         * Type parameters:
         * <T> – the type of the first argument to the function
         * <U> – the type of the second argument to the function
         * <R> – the type of the result of the function
         */
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        /*

        //Anonymous class
          BiFunction<Integer, Integer, Integer> sum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

         */
        System.out.println(sum.apply(5,7));




    }


}
