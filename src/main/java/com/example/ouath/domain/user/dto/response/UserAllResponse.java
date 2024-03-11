package com.example.ouath.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class UserAllResponse {

    private UUID id;
    private String name;

    private Integer grade;

    private Integer class_num;

    private Integer num;

}
