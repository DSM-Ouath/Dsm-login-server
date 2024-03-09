package com.example.ouath.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // user
    USER_NOT_FOUND(404, "일치하는 유저가 존재하지 않습니다."),

    // jwt
    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),
    REFRESH_TOKEN_NOT_FOUND(404, "일치하는 리프레쉬토큰이 존재하지 않습니다."),

    // general
    BAD_REQUEST(400, "프론트 탓..."),
    INTERNAL_SERVER_ERROR(500, "서버 탓..."),

    // key
    INVALID_KEY(401, "잘못된 key입니다.");

    private final int statusCode;
    private final String message;
}
