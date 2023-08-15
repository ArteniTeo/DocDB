package com.DocDB.validator;

import com.DocDB.exception.InvalidEmailException;
import com.DocDB.exception.InvalidPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class UserValidator {


    public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    public static void verifyPassword(String password) {
        String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{5,20}$";
        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null || !pat.matcher(password).matches()) {
            throw new RuntimeException("Invalid password");
        }
    }
}
