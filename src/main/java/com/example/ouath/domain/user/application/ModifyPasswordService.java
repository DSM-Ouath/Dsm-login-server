package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.dto.request.AuthRequest;
import com.example.ouath.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyPasswordService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void modifyPassword(AuthRequest request) {
        User user = userRepository.findByAccountId(request.getAccount_id())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.modifyPassword(passwordEncoder.encode(request.getPassword()));
    }
}
