package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.dto.response.DuplicateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountIdDuplicatedCheckService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public DuplicateResponse accountIdDuplicatedCheck(String accountId) {
        if(userRepository.existsByAccountId(accountId)) {
            return new DuplicateResponse(true);
        }
        return new DuplicateResponse(false);
    }
}
