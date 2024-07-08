package com.example.ouath.domain.test.dto.response;

import com.example.ouath.domain.test.dto.request.TestRequest;
import lombok.Getter;

@Getter
public class TestResponse {

    private String result = "fail";

    public TestResponse(TestRequest request) {
        this.result = request.getResult();
    }
}
