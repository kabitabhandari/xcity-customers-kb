package com.things.customer.xcitycustomerskb.multithreading.resolvingunsync;

public class MovieSeats {
    static int TOTAL_SEATS = 10;

    synchronized void bookSeats(int askedSeats){
        System.out.println("current thread ==> " +    Thread.currentThread().getName());

        if(TOTAL_SEATS >= askedSeats){
            System.out.println("Seats Booked Successfully");
            TOTAL_SEATS = TOTAL_SEATS-askedSeats;
            System.out.println("Seats Left is " + TOTAL_SEATS );
        }
        else{
            System.out.println("Cannot book seats as available total seats = " + TOTAL_SEATS);
        }
    }
}
