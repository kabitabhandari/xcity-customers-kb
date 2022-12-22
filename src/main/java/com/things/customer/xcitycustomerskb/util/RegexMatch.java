package com.things.customer.xcitycustomerskb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {
    public static void main(String[] args) {

        //long way
        Pattern pattern = Pattern.compile(".m");
        Matcher m = pattern.matcher(".am");
        System.out.println(m.matches());

        //quickway
        boolean result2 =  Pattern.matches(".m", "am");
        System.out.println(result2);

        //quickway
        System.out.println(Pattern.matches("[amn]", "am"));  // T or F
        System.out.println(Pattern.matches("[^amn]", "a"));  // T or F
        System.out.println(Pattern.matches("^a.c.", "abcd"));  // T or F

        //very quick
        String str = "bbb";
        System.out.println("Using Pattern matches method: " + Pattern.matches(".bb", str));
        System.out.println("Using String matches method: " + str.matches(".bb"));

        //matches any single character: .
        System.out.println("example 1: " + Pattern.matches(".", "h"));

        //Matches regex at the beginning of the line:  ^the
        Pattern p1 = Pattern.compile("^the"); //if we remove ^ then count = 5
        Matcher m1 = p1.matcher("the main goal of the team is the them them");
        int count =0;
        while(m1.find()){
            count++;
        }
        System.out.println("count is " + count);



        //Can match any of the letter a, b or c.
        System.out.println("example 2: " + Pattern.matches("^[abc]d.", "ad9"));


        System.out.println("example 3: " + Pattern.matches("[ab]...[12]", "a9uy2"));
        System.out.println("example 4: " + Pattern.matches("[ab]+", "aaaaaaaaab"));



        System.out.println("example 5 IP address: " + Pattern.matches(" ^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.", "1."));
        System.out.println("example name validation : " + Pattern.matches("^([a-zA-Z])[[a-zA-Z\\d_]]{7,29}", "kabitaToy789_"));
        System.out.println("example name validation : " + Pattern.matches("[a-zA-Z]{1}[\\w]{7,29}", "kabitaToy789_"));

    }
}
