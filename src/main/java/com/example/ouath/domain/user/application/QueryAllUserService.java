package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.exception.InvalidUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllUserService {

    private final UserRepository userRepository;

    @Value("${key.secret-key}")
    private String yamlSecretKey;

    @Transactional(readOnly = true)
    public List<User> queryAllUser(String secretKey) {
        if(!yamlSecretKey.equals(secretKey)) throw InvalidUserException.EXCEPTION;

        return userRepository.findAll();
    }
}
