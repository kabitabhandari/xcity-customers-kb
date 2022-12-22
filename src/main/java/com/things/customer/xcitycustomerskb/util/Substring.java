package com.things.customer.xcitycustomerskb.util;

import java.util.*;
import java.util.function.Predicate;

public class Substring {
    public static void main(String[] args) {
        String s = "welcometojava";
       int  k = 3;
       int m = 0;

       String [] subStrArray = new String[s.length()];


        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if(s.substring(i, j).length() == k){
                    subStrArray[m] = (s.substring(i, j));
                    m++;
                }
            }
        }



        String[] removedNull = Arrays.stream(subStrArray)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        if(s == null) {
                            return false;
                        }
                        return true;
                    }
                })
                .sorted()
                .toArray(size -> new String[size]);



        System.out.println(removedNull[0]);
        System.out.println(removedNull[m-1]);
    }
}
