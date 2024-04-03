package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BanUserForm {
    @NotBlank(message = "deleteFlag不可以为空")
    private Integer deleteFlag;
    @NotNull(message = "userId不可以为空")
    private String userId;

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BanUserForm{" +
                "deleteFlag='" + deleteFlag + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
