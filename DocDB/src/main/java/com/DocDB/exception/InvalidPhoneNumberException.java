package com.DocDB.exception;

import com.DocDB.common.dto.ErrorCode;
import com.DocDB.common.web.BusinessException;

public class InvalidPhoneNumberException extends BusinessException {
    public InvalidPhoneNumberException(String resourceName) {
        super(ErrorCode.BAD_REQUEST_DATA, String.format("Invalid phone number %s.", resourceName));
    }

}
