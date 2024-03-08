package com.example.ouath.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    private String name;

    private LocalDate birthday;

    private Integer classNumber;

    private String accountId;

    private String password;

    private String passwordCheck;
}
