package com.things.customer.xcitycustomerskb.switchstatement;

public class Days {
    public static void main(String ... args) {
        int dayFromSurvey = 4; // try with 3


        switch(dayFromSurvey){  // value that needs to be tested .

            case 1:
                System.out.println("This is a Regular Day");
                break;

            case 3:
                break;

            case 4:
                System.out.println("This is a BAD BAD Day");

            case 5:
                System.out.println("This is a horrible Day");
                break;

            case 6:
                System.out.println("This is a kind Day");
                break;

        }

    }
}
