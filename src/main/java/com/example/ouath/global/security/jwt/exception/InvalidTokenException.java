package com.example.ouath.global.security.jwt.exception;

import com.example.ouath.global.error.exception.BusinessException;
import com.example.ouath.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}