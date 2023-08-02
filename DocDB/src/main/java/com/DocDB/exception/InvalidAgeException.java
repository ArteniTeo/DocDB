package com.DocDB.exception;

import com.DocDB.common.dto.ErrorCode;
import com.DocDB.common.web.BusinessException;

import java.sql.Date;

public class InvalidAgeException extends BusinessException {
    public InvalidAgeException(Date resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("Your are not at least 18 years old.( %s )", resourceName));
    }

}