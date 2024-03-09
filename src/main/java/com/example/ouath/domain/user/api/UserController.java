package com.example.ouath.domain.user.api;

import com.example.ouath.domain.user.application.ClassNumberDuplicatedCheckService;
import com.example.ouath.domain.user.application.SignupService;
import com.example.ouath.domain.user.dto.request.SignupRequest;
import com.example.ouath.domain.user.dto.response.DuplicateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignupService signupService;

    private final ClassNumberDuplicatedCheckService classNumberDuplicatedCheckService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{classNumber}")
    public DuplicateResponse classNumberDuplicatedCheck(@PathVariable Integer classNumber) {
        return classNumberDuplicatedCheckService.classNumberDuplicatedCheck(classNumber);
    }
}
