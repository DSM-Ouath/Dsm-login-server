package com.example.ouath.domain.user.exception;

import com.example.ouath.global.error.exception.BusinessException;
import com.example.ouath.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}