package com.example.ouath.domain.user.domain;

import com.example.ouath.domain.user.enums.UserRole;
import com.example.ouath.domain.user.enums.UserState;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "tbl_user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "entrance_year")
    private Integer entranceYear;

    @Column(name = "birt_day")
    private LocalDate birthDay;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "profile_file_name")
    private String profileFileName;

    @Column(name = "password")
    private String password;

    @Column(name = "account_id",unique = true)
    private String accountId;

    @Column(name = "class_num")
    private Integer classNum;

    @Column(name = "num")
    private Integer num;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private UserState userState;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
