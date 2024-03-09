package com.example.ouath.domain.user.dao;

import com.example.ouath.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByAccountId(String accountId);
    Boolean existsByGradeAndClassNumAndNum(Integer grade, Integer classNum, Integer num);
    Boolean existsByAccountId(String accountId);
}
