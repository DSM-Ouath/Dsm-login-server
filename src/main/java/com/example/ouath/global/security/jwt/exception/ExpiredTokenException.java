package com.example.ouath.global.security.jwt.exception;

import com.example.ouath.global.error.exception.BusinessException;
import com.example.ouath.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}