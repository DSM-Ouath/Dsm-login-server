package com.example.ouath.domain.user.exception;

import com.example.ouath.global.error.exception.BusinessException;
import com.example.ouath.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}
