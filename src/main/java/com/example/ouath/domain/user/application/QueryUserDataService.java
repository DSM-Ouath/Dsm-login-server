package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.dto.response.UserDataResponse;
import com.example.ouath.domain.user.exception.PasswordMisMatchException;
import com.example.ouath.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryUserDataService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserDataResponse queryUserDate(String accountId, String password) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(password, user.getPassword()))
            throw PasswordMisMatchException.EXCEPTION;

        return UserDataResponse.builder()
                .id(user.getId())
                .account_id(user.getAccountId())
                .password(user.getPassword())
                .name(user.getName())
                .password(user.getPassword())
                .grade(user.getGrade())
                .class_num(user.getClassNum())
                .num(user.getNum())
                .user_role(String.valueOf(user.getRole()))
                .build();
    }
}