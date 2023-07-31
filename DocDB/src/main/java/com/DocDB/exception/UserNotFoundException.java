package com.DocDB.exception;

import com.DocDB.common.web.NotFoundException;
import com.DocDB.entities.User;
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super(id, User.RESOURCE_NAME);
    }

    public UserNotFoundException(String email) {
        super(email, User.RESOURCE_NAME);
    }
}
