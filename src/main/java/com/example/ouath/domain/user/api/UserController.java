package com.example.ouath.domain.user.api;

import com.example.ouath.domain.user.application.AccountIdDuplicatedCheckService;
import com.example.ouath.domain.user.application.ClassNumberDuplicatedCheckService;
import com.example.ouath.domain.user.application.QueryAllUserService;
import com.example.ouath.domain.user.application.QueryUserDataService;
import com.example.ouath.domain.user.application.SignupService;
import com.example.ouath.domain.user.domain.User;
import com.example.ouath.domain.user.dto.request.SignupRequest;
import com.example.ouath.domain.user.dto.response.DuplicateResponse;
import com.example.ouath.domain.user.dto.response.UserDataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignupService signupService;

    private final ClassNumberDuplicatedCheckService classNumberDuplicatedCheckService;

    private final AccountIdDuplicatedCheckService accountIdDuplicatedCheckService;

    private final QueryUserDataService queryUserDataService;

    private final QueryAllUserService queryAllUserService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/class-number-check/{classNumber}")
    public DuplicateResponse classNumberDuplicatedCheck(@PathVariable Integer classNumber) {
        return classNumberDuplicatedCheckService.classNumberDuplicatedCheck(classNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/account-id-check/{accountId}")
    public DuplicateResponse accountIdDuplicatedCheck(@PathVariable String accountId) {
        return accountIdDuplicatedCheckService.accountIdDuplicatedCheck(accountId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user-data")
    public UserDataResponse queryUserData(@RequestParam("account_id") String accountId, @RequestParam("password") String password) {
        return queryUserDataService.queryUserDate(accountId, password);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user-all")
    public List<User> queryAllUser(@RequestParam("secret_key") String secretKey) {
        return queryAllUserService.queryAllUser(secretKey);
    }
}
