package com.akicat.knowledgeshare.request;

public class TemplateDeleteRequest {
    private String userId;
    private String tempId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }
}
