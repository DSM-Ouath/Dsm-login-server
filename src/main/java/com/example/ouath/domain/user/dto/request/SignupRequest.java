package com.example.ouath.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupRequest {

    @NotBlank
    @Size(min = 2, max = 4, message = "이름은 2글자 이상, 4글자 이하여야 합니다.")
    private String name;

    @NotNull
    private LocalDate birth_day;

    @NotNull
    @Size(min = 4, max = 4, message = "학번은 4글자 이어야 합니다.")
    private Integer class_number;

    @NotBlank
    private String account_id;

    @NotBlank
    @Pattern(
            regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" + "<=>?@＼^_`{|}~]{8,30}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다."
    )
    private String password;

    @NotBlank
    private String password_check;
}
