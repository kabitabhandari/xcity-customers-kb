package com.things.customer.xcitycustomerskb.switchstatement;

public class DayStatus {
    public static void main(String ... args) {
        int day = 1;

        switch(day){
            case 1:
                System.out.println("Regular Day");
            case 2:
                System.out.println("OK Day");
            case 3:
                System.out.println("Hard Day");
            case 4:
            case 5:
            case 6:
                System.out.println("bad Day");
                break;
            case 7:
                System.out.println("Rainy Day");

            case 8:
                System.out.println("cold Day");
                break;

            default:
                System.out.println("invalid Day");
        }

    }

}
