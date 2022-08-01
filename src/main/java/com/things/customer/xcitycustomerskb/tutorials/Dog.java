package com.things.customer.xcitycustomerskb.tutorials;

public class Dog implements Printable {
    public String name;
    public int age;

    public Dog() {}

    @Override
    public String print(String prefix, String suffix) {
        String result = prefix + " MEOW " + suffix;
        System.out.println(result);
        return result;

    }

}
