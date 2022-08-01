package com.things.customer.xcitycustomerskb.generics;

public class GenericsExample {
    public static void main(String[] args) {
        Printer<Integer> printerInteger = new Printer<>(23);
        printerInteger.print();

        Printer<Double> printerDouble = new Printer<>(29.99);
        printerDouble.print();

        Printer<String> printerString = new Printer<>("hello");
        printerString.print();

        Printer<Monkey> printerMonkey = new Printer<>(new Monkey("lucy", 3));
        printerMonkey.print();

        AdvPrinter<Rabbit> advPrinter = new AdvPrinter<>(new Rabbit("browny", 7));
        advPrinter.printAdvance();

        printByShouting(35, "tree");
        printByShouting(35.99, 8.09);
        printByShouting("Pass ", "fail");
        printByShouting(new Monkey("Monkey Happy", 6), "....chasing this monkey.....");
        printByShouting(new Rabbit("Rabbit Hole", 13), new Monkey("Monkey Dead ", 16));

    }


    private static <T, V> void  printByShouting(T message1, V message2){ // note: we can write return type as T or V instead of void
        System.out.println(message1 + "!!!!" + "  " + message2);
    }
}
