package com.things.customer.xcitycustomerskb.testingexceptions;

public class Consumer {
    public static void main(String[] args) {
        try {
            update(5);
        }catch(Exception e){
            System.out.println("main-class-catch");
        }

        System.out.println("999999999999999");

    }

    private static void update(int num) {
            int p = realUpdate(num);
        System.out.println(" ");
    }

    private static int realUpdate(int num) {

            if(num >10){
                System.out.println("win");
                return num;
            }
            else{
                throw new ArithmeticException("my exception kbi");
            }


    }
}
