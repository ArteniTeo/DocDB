package com.DocDB.validator;

import com.DocDB.common.Gender;
import com.DocDB.exception.InvalidPhoneNumberException;
import com.DocDB.exception.InvalidAgeException;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class PatientValidator {
    public static boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() >= 7 && phoneNumber.length() <= 12) {
            for (char c : phoneNumber.toCharArray()) {
                if (!Character.isDigit(c)) throw new InvalidPhoneNumberException(phoneNumber);
            }
        } else throw new InvalidPhoneNumberException(phoneNumber);
        return true;
    }

    public static boolean verifyAge(Date birthDay) {
        Date currentDate = new Date(System.currentTimeMillis());
        long difInMills = currentDate.getTime() - birthDay.getTime();
        long difInDays = TimeUnit.DAYS.convert(difInMills, TimeUnit.MILLISECONDS);
        long difInYears = difInDays / 365;
        if (difInYears < 18) {
            throw new InvalidAgeException(birthDay);
        }
        return true;
    }

    public static boolean verifyCnp(String cnp, Date birthDay, Gender gender) {
        boolean bornBefore00;

        //verify Gender
        int expectedGender = Character.getNumericValue(cnp.charAt(0));
        if (gender.equals(Gender.MALE)) {
            if (expectedGender == 1) {
                bornBefore00 = true;
            } else if (expectedGender == 5) {
                bornBefore00 = false;
            } else {
                throw new RuntimeException("Invalid CNP, gender does not match.");
            }
        } else {
            if (expectedGender == 2) {
                bornBefore00 = true;
            } else if (expectedGender == 6) {
                bornBefore00 = false;
            } else {
                throw new RuntimeException("Invalid CNP, gender does not match.");
            }
        }
        if (bornBefore00) {
            if (Character.getNumericValue(cnp.charAt(0)) != 1 && Character.getNumericValue(cnp.charAt(0)) != 2)
                throw new RuntimeException("Invalid CNP, first digit does not correspond");
        } else {
            if (Character.getNumericValue(cnp.charAt(0)) != 5 && Character.getNumericValue(cnp.charAt(0)) != 6)
                throw new RuntimeException("Invalid CNP, first digit does not correspond");
        }

        //verify birthday
        int yy = Character.getNumericValue(cnp.charAt(1)) * 10 + Character.getNumericValue(cnp.charAt(2)) + 100;
        int mm = Character.getNumericValue(cnp.charAt(3)) * 10 + Character.getNumericValue(cnp.charAt(4)) - 1;
        int dd = Character.getNumericValue(cnp.charAt(5)) * 10 + Character.getNumericValue(cnp.charAt(6));
        Date cnpBirthDay = new Date(yy, mm, dd);

        if (!cnpBirthDay.equals(birthDay))
            throw new RuntimeException("Invalid CNP, CNP birth day and given birth day do not correspond.");

        //verify control digit
        int[] coefficient = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnp.charAt(i)) * coefficient[i];
        }
        int controlDigit = sum % 11;
        if (controlDigit == 10) controlDigit = 1;
        int lastDigit = Character.getNumericValue(cnp.charAt(12));
        if (controlDigit != lastDigit) throw new RuntimeException("Invalid CNP, control digit is invalid");

        return true;
    }
}
