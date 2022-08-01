package com.things.customer.xcitycustomerskb.tutorials.enums;

public enum Breakfast {
    PANCAKES(65),
    SUSSAGE(70),
    HASHBROWN(99),
    CEREALS(25),
    WAFFLE(55);

    final int levelOfDeliciousness;

    Breakfast(int levelOfDeliciousness) {
        this.levelOfDeliciousness = levelOfDeliciousness;
    }
}
