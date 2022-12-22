package com.things.customer.xcitycustomerskb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitClass {



            public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            String [] arr2 = s.trim().split("[ !,?._'@]+" );


            System.out.println(">>> " + s.length());;

            int size = (s.trim().isEmpty()) ? 0 : arr2.length;

            System.out.println(size);


            for(String ss : arr2){
                System.out.println(ss);
            }

            scan.close();
        }
    }

