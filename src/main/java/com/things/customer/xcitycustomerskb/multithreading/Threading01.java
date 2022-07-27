package com.things.customer.xcitycustomerskb.multithreading;

/**
 * Two ways to create thread: using Thread class and Implementing Runnable Interface
 */

public class Threading01 extends Thread{

        public void run(){
            System.out.println("i am first run method");
        }


    public static void main(String[] args) {
        //Performing Single task from single thread
        Threading01 t = new Threading01();
        t.start();


        //Performing Single task from multiple threads
        Threading01 t2 = new Threading01();
        t2.start();

        //Performing Multiple task from single thread  ---> not possible

    }

}
