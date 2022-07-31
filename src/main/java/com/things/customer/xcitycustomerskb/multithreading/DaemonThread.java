package com.things.customer.xcitycustomerskb.multithreading;

public class DaemonThread extends Thread {

    public static void main(String[] args) {
        System.out.println("main thread =" + Thread.currentThread().getName());
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();

    }

    public void run() {
        System.out.println("daemon thread");
    }

}
