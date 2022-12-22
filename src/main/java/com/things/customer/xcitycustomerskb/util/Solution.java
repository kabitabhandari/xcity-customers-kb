package com.things.customer.xcitycustomerskb.util;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            new MyRegex().print();
            System.out.println(IP.matches(new MyRegex().pattern));
    }
    }}

    //Write your code here.
     class MyRegex
    {
       // String pattern ="^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";

        String pattern =
                        "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        void print(){
            System.out.println(pattern);

        }

    }







//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//
//        //Scanner in = new Scanner(System.in);
//        //while(in.hasNext()){
//        // String IP = in.next();
//        String IP = "666.666.23.23";
//        //String IP = ".213.123.23";
//        //String IP = "23.45.22.32.";
//        boolean result = false;
//
//        if (!IP.startsWith(".") && !IP.endsWith(".")){
//
//             result = checkValidity(IP);
//        }
//
//        if (result) {
//            System.out.println(IP.matches(new MyRegex().pattern));
//        } else {
//            System.out.println(result);
//        }
//        //}
//    }
//
//    public static boolean checkValidity(String IP) {
//        String[] array = IP.split("\\.");
//        System.out.println(array.length);
//        if (array.length == 4) {
//            for (String s : array) {
//                System.out.println("each item is :  " + s);
//
//                if (s.length() <= 3  && Integer.parseInt(s) <= 255) {
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
//        return true;
//    }
//
//    public static class MyRegex {
//        private static final String pattern = "[\\d.\\d.\\d.\\d]+";
//    }
