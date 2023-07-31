package com.DocDB.validator;

import com.DocDB.exception.InvalidEmailException;
import com.DocDB.exception.InvalidPasswordException;

public class UserValidator {

    public static void verifyEmail(String email) {
        if (!email.contains("@")) throw new InvalidEmailException(email);
//        if (getUserByEmail(email) != null) throw new InvalidEmailException(email);
    }

    public static void verifyPassword(String password) {
        if (password.length() < 5) throw new InvalidPasswordException(password);
    }
}
