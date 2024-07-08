package com.example.ouath.domain.test.dto.response;

import lombok.Getter;

@Getter
public class TestResponse {

    private String result = "fail";

    public TestResponse(String result) {
        this.result = result;
    }
}
