package com.example.ouath.domain.test.application;

import com.example.ouath.domain.test.dto.request.TestRequest;
import com.example.ouath.domain.test.dto.response.TestResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestResponse test(String request, String request2) {
        return new TestResponse(request, request2);
    }
}
