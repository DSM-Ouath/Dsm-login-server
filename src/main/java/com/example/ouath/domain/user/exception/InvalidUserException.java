package com.example.ouath.domain.user.exception;

import com.example.ouath.global.error.exception.BusinessException;
import com.example.ouath.global.error.exception.ErrorCode;

public class InvalidUserException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidUserException();

    public InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
