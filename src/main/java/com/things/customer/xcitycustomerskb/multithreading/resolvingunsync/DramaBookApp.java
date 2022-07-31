package com.things.customer.xcitycustomerskb.multithreading.resolvingunsync;


public class DramaBookApp extends Thread {
    MovieSeats movieSeats = new MovieSeats();
    int seats;

    public static void main(String[] args) {
        DramaBookApp firstCustomer = new DramaBookApp();
        firstCustomer.seats = 8;
        firstCustomer.start();

        DramaBookApp secondCustomer = new DramaBookApp();
        secondCustomer.seats = 9;
        secondCustomer.start();

    }

    public void run() {
        movieSeats.bookSeats(seats);
    }
}
