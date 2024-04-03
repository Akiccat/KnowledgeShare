package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SetAsAdminForm {
    @NotBlank(message = "userId不可以为NULL")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SetAsAdminForm{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
