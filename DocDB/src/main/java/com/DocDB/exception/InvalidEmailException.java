package com.DocDB.exception;

import com.DocDB.common.dto.ErrorCode;
import com.DocDB.common.web.BusinessException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException(String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("Invalid email address %s.", resourceName));
    }

}