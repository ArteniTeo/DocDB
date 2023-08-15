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

    //TODO implement all password rules
    /**
     * password requirements:
     * min 5 max 20 - DONE
     * lower case
     * upper case
     * digits
     * special characters: !@#$
     * @param password
     */
    public static void verifyPassword(String password) {
        if (password.length() < 5 || password.length() > 20) throw new InvalidPasswordException(password);
    }
}
