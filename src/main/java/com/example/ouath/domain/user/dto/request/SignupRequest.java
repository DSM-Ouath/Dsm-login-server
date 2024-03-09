package com.example.ouath.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    private String name;

    private LocalDate birth_day;

    private Integer class_number;

    private String account_id;

    private String password;

    private String password_check;
}
