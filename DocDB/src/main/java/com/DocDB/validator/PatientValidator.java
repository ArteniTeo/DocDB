package com.DocDB.validator;

import com.DocDB.exception.InvalidPhoneNumberException;
import com.DocDB.exception.InvalidAgeException;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class PatientValidator {
    public static void verifyPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() >= 7 && phoneNumber.length() <= 12) {
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) throw new InvalidPhoneNumberException(phoneNumber);
            }
        } else throw new InvalidPhoneNumberException(phoneNumber);
    }

    public static boolean verifyAge(Date birthDay){
        Date currentDate = new Date(System.currentTimeMillis());
        long difInMills = currentDate.getTime() - birthDay.getTime();
        long difInDays = TimeUnit.DAYS.convert(difInMills, TimeUnit.MILLISECONDS);
        long difInYears = difInDays / 365;
        if(difInYears < 18) { throw new InvalidAgeException(birthDay); }
        return true;
    }
}
