package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.dto.response.DuplicateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassNumberDuplicatedCheckService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public DuplicateResponse classNumberDuplicatedCheck(Integer classNumber) {
        if(userRepository.existsByGradeAndClassNumAndNum(
                classNumber/1000, classNumber%1000/100, classNumber%100)
        ) {
            return new DuplicateResponse(true);
        }
        else return new DuplicateResponse(false);
    }
}
