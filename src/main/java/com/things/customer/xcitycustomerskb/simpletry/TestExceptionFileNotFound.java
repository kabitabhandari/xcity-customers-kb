package com.things.customer.xcitycustomerskb.simpletry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestExceptionFileNotFound {
    public static void main(String[] args) throws FileNotFoundException {
        TestExceptionFileNotFound.fi();
      // exceptionKB();

       TestExceptionFileNotFound test = new TestExceptionFileNotFound();
       test.exceptionKB();


    }


    private  void exceptionKB() throws FileNotFoundException {
        System.out.println("start");

        File file = new File(
                "C:\\Users\\pankaj\\Desktop\\test.txt");


        try {
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        System.out.println(String.join("|", "hip", "hop"));

    }









    private static void fi() {
        FunctionalInterfaceKB fI1  = new  FunctionalInterfaceKB(){
            public void disp(){
                System.out.println("this is an old style of implementing functional interface.");
            }
        };
        fI1.disp();


        FunctionalInterfaceKB It1 = () -> System.out.println("func implementation");
        It1.disp();


        ////////////

        SomeInterface ti1 = new SomeInterface() {
            @Override
            public void m1() {
                System.out.println("style of implementing regular interface m1().");
            }

            @Override
            public void m4() {
                System.out.println("style of implementing regular interface m4().");

            }

        };
        ti1.m1();
        ti1.m2();
        ti1.m4();
    }



}
