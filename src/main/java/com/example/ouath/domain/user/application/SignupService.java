package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.dto.request.SignupRequest;
import com.example.ouath.domain.user.domain.enums.UserRole;
import com.example.ouath.domain.user.domain.enums.UserState;
import com.example.ouath.domain.user.exception.PasswordMisMatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest request) {

        if(!request.getPassword().equals(request.getPasswordCheck())) throw PasswordMisMatchException.EXCEPTION;

        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .entranceYear(24) // 일단은 입학년도를 24년도로 고정해둠
                        .birthDay(request.getBirthday())
                        .grade(request.getClassNumber()/1000)
                        .classNum(request.getClassNumber()%1000/100)
                        .num(request.getClassNumber()%100)
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .userState(UserState.CREATED)
                        .role(UserRole.STU)
                        .build());
    }
}
