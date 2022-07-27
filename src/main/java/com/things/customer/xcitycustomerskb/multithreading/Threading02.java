package com.things.customer.xcitycustomerskb.multithreading;

public class Threading02 extends Thread{
    //Performing Multiple task from multiple threads
    //create multiple classes to create multiple run()

        public void run(){
            System.out.println("i am second run method");
        }



    public static void main(String[] args) {
        //both threads t1 and t2 will excecute at same time.
        Threading02 t2 = new Threading02();   // class Threading02
        t2.start();

        Threading01 t1 = new Threading01(); //class Threading02
        t1.start();
    }


}
