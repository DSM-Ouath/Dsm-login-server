package com.example.ouath.domain.user.dto.response;

import com.example.ouath.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserDataResponse {

    private String account_id;

    private String password;

    private String name;

    private Integer grade;

    private Integer class_num;

    private Integer num;

    private UserRole user_role;
}
