package com.things.customer.xcitycustomerskb.multithreading.unsyncissues;

public class Theater {
    static int TOTAL_SEATS = 10;

     public void bookSeats(int askedSeats){

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
