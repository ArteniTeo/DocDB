package com.DocDB.validator;

import com.DocDB.exception.InvalidEmailException;
import com.DocDB.exception.InvalidPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class UserValidator {


    public static void verifyEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || !pat.matcher(email).matches()) {
            throw new RuntimeException("Invalid email");
        }
    }

//    public static void verifyEmail(String email) {
//        int index = email.indexOf('@');
//
//        if (index != -1 && index < email.length() - 1) {
//            if(checkDomain(email.substring(index + 1))) { System.out.println("good"); }
//            else throw new RuntimeException("Invalid email");
//        } else throw new RuntimeException("Invalid email");
//    }

//    private static boolean checkDomain(String domain) {
//        String[] validDomains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
//
//        for (String validDomain : validDomains) {
//            if (validDomain.equalsIgnoreCase(domain)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void verifyPassword(String password) {
        if (password.length() < 5 || password.length() > 20) throw new InvalidPasswordException(password);
    }
}
