package com.airtribe.learntrack.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidate {

    private static final Pattern EMAIL_REGEX =  Pattern.compile("^[A-Za-z0-9+_]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$");

    public static boolean isValid(String email) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }

    public static String getValidEmail(Scanner sc) {
        while(true){
            System.out.println("Enter email");
            String email=sc.nextLine();
            if(EmailValidate.isValid(email)){
                return email;
            }
            else{
                System.out.println("Invalid Email");
            }
        }

    }
}