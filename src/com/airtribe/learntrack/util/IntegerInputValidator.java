package com.airtribe.learntrack.util;

import java.util.Scanner;

public class IntegerInputValidator {

    public static int checkIfInteger(Scanner sc){
        while(true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input!");
                System.out.println(" Enter an integer:");
                sc.next();
            }
        }
    }
}
