package com.things.customer.xcitycustomerskb.util;

import org.apache.el.lang.FunctionMapperImpl;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamC {
    // Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?

//    public static void main(String args[]) {
//        List<Integer> myList = Arrays.asList(1,45,4,2,3,55,36);
//        myList.stream().filter(f -> f %2 == 0).forEach(System.out::println);
//    }


    //Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
//    public static void main(String args[]) {
//        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
//
//       myList.stream()
//                .map(m -> String.valueOf(m))    //.map(m -> Integer.parseInt(m))
//                .filter(p -> p.startsWith("1"))
//                .forEach(p ->System.out.println(p));
//
//    }    public static void main(String args[]) {
//        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
//
//        List<Integer> myList2 = myList.stream()
//                .map(m -> String.valueOf(m))    //.map(m -> Integer.parseInt(m))
//                .filter(p -> p.startsWith("1"))
//                .map(Integer::parseInt).collect(Collectors.toList());
//
//        System.out.println(myList2);
//
//    }

    //Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
//    public static void main(String args[]) {
//        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
//
//        List<Integer> myList2 = myList.stream()
//                .map(m -> String.valueOf(m))
//                .filter(p -> p.startsWith("1"))
//                .map(new Function<String, Integer>() {
//
//                    @Override
//                    public Integer apply(String s) {
//                        return Integer.parseInt(s);
//                    }
//                })
//                .collect(Collectors.toList());
//
//        System.out.println(myList2);
//
//    }

    // How to find duplicate elements in a given integers list in java using Stream functions?
//    public static void main(String args[]) {
//
//        List<Integer> myList = Arrays.asList(10,15,10, 23, 23);
//        Map<Integer, Integer> myMap = new HashMap<>();
//        for(int i= 0; i< myList.size(); i++){
//            if(myMap.containsKey(myList.get(i))){
//                myMap.put(myList.get(i), myMap.get(myList.get(i)) + 1 );
//            }
//            else{
//                myMap.put(myList.get(i), 1);
//            }
//        }
//
//        for (Integer key: myMap.keySet()) {
//            if(myMap.get(key) >=2)
//            System.out.println(key);
//        }
//        System.out.println("map is :: " + myMap);
//    }


   // Q4 Given the list of integers, find the first element of the list using Stream functions?
   public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);

       System.out.println(myList.stream().findFirst());

   }

}
