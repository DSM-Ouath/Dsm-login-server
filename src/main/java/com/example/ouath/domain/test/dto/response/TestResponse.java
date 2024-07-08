package com.example.ouath.domain.test.dto.response;

import lombok.Getter;

@Getter
public class TestResponse {

    private String result = "fail";
    private String result2 = "fail";

    public TestResponse(String result, String result2) {
        this.result = result;
        this.result2 = result2;
    }
}
