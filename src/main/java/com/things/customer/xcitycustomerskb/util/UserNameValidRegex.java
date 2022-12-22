package com.things.customer.xcitycustomerskb.util;

import java.util.Scanner;

public class UserNameValidRegex {
    private static final Scanner scan = new Scanner(System.in);
    private static Object UsernameValidator;

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(new UsernameValidator().regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
 class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public  String regularExpression = "";
}
