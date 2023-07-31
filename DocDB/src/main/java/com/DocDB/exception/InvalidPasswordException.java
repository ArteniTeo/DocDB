package com.DocDB.exception;

import com.DocDB.common.dto.ErrorCode;
import com.DocDB.common.web.BusinessException;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException(String password) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("%s with id %s was not found", password));
    }

}