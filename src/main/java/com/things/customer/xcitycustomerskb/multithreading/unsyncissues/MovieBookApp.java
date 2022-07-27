package com.things.customer.xcitycustomerskb.multithreading.unsyncissues;


public class MovieBookApp extends Thread {
    Theater theater = new Theater();
     int seats;


    public void run(){
        theater.bookSeats(seats);
    }



    public static void main(String[] args) {
            MovieBookApp firstCustomer = new MovieBookApp();
            firstCustomer.seats = 6;
            firstCustomer.start();


            MovieBookApp secondCustomer = new MovieBookApp();
            secondCustomer.seats = 10;
            secondCustomer.start();

    }
}
