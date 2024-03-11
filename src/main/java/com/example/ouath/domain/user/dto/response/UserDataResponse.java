package com.example.ouath.domain.user.dto.response;

import com.example.ouath.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class UserDataResponse {

    private UUID id;

    private String account_id;

    private String password;

    private String name;

    private Integer grade;

    private Integer class_num;

    private Integer num;

    private String user_role;

    private LocalDate brith_day;
}
