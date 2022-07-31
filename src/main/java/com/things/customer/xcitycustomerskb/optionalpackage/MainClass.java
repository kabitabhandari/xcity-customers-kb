package com.things.customer.xcitycustomerskb.optionalpackage;

import java.util.Optional;

public class MainClass {
    public static void main(String[] args) {
        Optional<Cat> myCat = findCatByName("micky");


        //approach 1
        if(myCat.isPresent()){
            System.out.println("Age = " + myCat.get().getAge());
        } else {
            System.out.println(0);
        }

        //approach 2
        Cat c = myCat.orElse(new Cat("UNKNOWN", 0));
        System.out.println(c);

        //approach 3
        Cat d = myCat.orElseGet(() -> new Cat("UNKNOWN", 0));  // takes supplier
        System.out.println(d);

        //approach 4
        String e = myCat.map(Cat::getName).orElse("NO-Name");
        System.out.println(e);

        // what happens if we try to access null,
        System.out.println(myCat.get()); //NoSuchElementException: No value present

    }


    private static Optional<Cat> findCatByName(String name){
        //Cat myCat = new Cat(name, 3);
        Cat myCat = null;

        //myCat could either be null or have value.
        // If it has value then, ofNullable(myCat) will proceed with that value.
        // if myCat is null, then ofNullable(myCat) will create an empty optional, note: it won't proceed with null.
        return Optional.ofNullable(myCat); // It will either give optional with value or give empty optional.

       // return Optional.of(myCat); // If you for sure know that myCat is not null then use Optional.of()

    }



    // where to use optional?
    // use it as a return type like we have used in this example. It is NOT used everywhere we have null variable, it is used in this type of scenario only.
}
