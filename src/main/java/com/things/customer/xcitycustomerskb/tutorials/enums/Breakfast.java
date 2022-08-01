package com.things.customer.xcitycustomerskb.tutorials.enums;

public enum Breakfast {
    PANCAKES(65, 7.99),
    SUSSAGE(70, 9.99),
    HASHBROWN(99, 5.99),
    CEREALS(25, 3.99),
    WAFFLE(55, 9.99);

    final int levelOfDeliciousness;
    final double price;

    Breakfast(int levelOfDeliciousness, double price) {
        this.levelOfDeliciousness = levelOfDeliciousness;
        this.price = price;
    }
}
