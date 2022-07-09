package com.things.customer.xcitycustomerskb.multithreading;

public class ThreadPriority extends Thread {
    /**
     * priority 1 to 10
     * 1 = min_priority
     * 5 = norm_priority
     * 10 = max_priority
     *
     * priority depends on platform. does not work on windows machine
     */
    public void run(){
        System.out.println("Child thread priority for thread = " +Thread.currentThread().getName() + ",  priority is = " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args){
        System.out.println("Main thread priority = " + Thread.currentThread().getPriority());
        System.out.println();

        ThreadPriority dt = new ThreadPriority();
        dt.setPriority(3);
        dt.start();
        ThreadPriority dt2 = new ThreadPriority();
        dt2.setPriority(7);
        dt2.start();



    }
}
