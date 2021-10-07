package com.chamith.employeems.payload.request;

import javax.validation.constraints.NotBlank;

public class LogOutRequest {

    private Long userId;

    public Long getUserId() {
        return userId;
    }
}
