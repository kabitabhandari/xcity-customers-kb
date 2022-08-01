package com.things.customer.xcitycustomerskb.tutorials.enums;

public class EnumTutorials {
    public static void main(String[] args) {
        Breakfast breakfast = Breakfast.CEREALS;
        System.out.println("breakfast >>> " + breakfast);

        int level = Breakfast.CEREALS.levelOfDeliciousness;
        System.out.println("level >>> " + level);

        for (Breakfast b : Breakfast.values()) {
            System.out.println(b + " " + b.levelOfDeliciousness);
        }
    }
}
