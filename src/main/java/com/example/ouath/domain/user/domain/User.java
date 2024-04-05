package com.example.ouath.domain.user.domain;

import com.example.ouath.domain.user.domain.enums.UserRole;
import com.example.ouath.domain.user.domain.enums.UserState;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "tbl_user")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(
            columnDefinition = "BINARY(16)",
            nullable = false
    )
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "entrance_year")
    private Integer entranceYear;

    @Column(name = "birth_day")
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

    @Column(name = "club", columnDefinition = "VARCHAR(255)")
    private String club;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private UserState userState;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    public void modifyProfile(String profileImgUrl) {
        this.profileFileName = profileImgUrl;
    }
}
