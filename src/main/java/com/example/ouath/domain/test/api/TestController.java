package com.example.ouath.domain.test.api;

import com.example.ouath.domain.test.application.TestService;
import com.example.ouath.domain.test.dto.request.TestRequest;
import com.example.ouath.domain.test.dto.response.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    public TestResponse test(@RequestBody TestRequest request) {
        return testService.test(request);
    }
}
