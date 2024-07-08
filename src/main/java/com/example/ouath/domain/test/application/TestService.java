package com.example.ouath.domain.test.application;

import com.example.ouath.domain.test.dto.request.TestRequest;
import com.example.ouath.domain.test.dto.response.TestResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestResponse test(TestRequest request) {
        return new TestResponse(request.getResult());
    }
}
