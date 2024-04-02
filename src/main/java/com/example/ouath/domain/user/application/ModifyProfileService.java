package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyProfileService {

    private final UserRepository userRepository;

    @Transactional
    public void modifyProfile(String accountId, String profileImgUrl) {
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.modifyProfile(profileImgUrl);
    }
}
