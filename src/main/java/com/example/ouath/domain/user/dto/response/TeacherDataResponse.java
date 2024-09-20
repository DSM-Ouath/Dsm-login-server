package com.example.ouath.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class TeacherDataResponse {

    private UUID id;

    private String account_id;

    private String password;

    private String name;
}
