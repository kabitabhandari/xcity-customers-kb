package com.things.customer.xcitycustomerskb.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class K {
    public static void main(String[] args) {
        Instant dateInstant =  Instant.now();
        System.out.println("Instant date now is " + dateInstant);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateInstant, ZoneOffset.UTC);
        System.out.println("localDateTime " + localDateTime);
        System.out.println("localDateTime in pega format " + localDateTime.toString().replaceAll("-", "").replaceAll(":", ""));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now());

    }
}
