package com.things.customer.xcitycustomerskb.tutorials.Lamda;

public class Lamdas {

    public static void main(String[] args) {
        /*
        without using LAMDAS::
        If we had to call a method "printThing" e.g ===>  printThing(Printable thing)
        which takes in as a parameter a Printable, which can be any object that implements the Printable Interface.
        then we would first have to create a new class called Dog and make it implement Printable interface.
        Then create an object of Dog class and use this object (assuming Dog class is implementing Printable interface)
        as a parameter to call the method printThing(Printable thing).
      */
        Dog poodle = new Dog();  // object of Dog class
        Lamdas.printThing(poodle); // using 'object of Dog class' to call Printable.


        /*
        BUT::
        With Lamdas, we do not have to create any extra Class to implement method Like => printThing(Printable dog)
         */
        Printable lamdaPrintable = ((p, s) -> {
            System.out.println(" start == "+ "meow.. from lamdas" + "!!");
            return (" start == "+ "meow.. from lamdas" + "!!");
        });
        printThing(lamdaPrintable);

    }


    /**
     * This method takes in as a parameter a Printable, which can be any object that implements the Printable Interface.
     * so what it actually looking for is, any class that is implementing Printable interface is good to send here
     */
    static void printThing(Printable thing) {
        thing.print("hi", "####");
    }

}
