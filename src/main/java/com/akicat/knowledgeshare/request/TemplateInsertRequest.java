package com.akicat.knowledgeshare.request;

public class TemplateInsertRequest {
    private String userId;
    private String tempContent;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent;
    }
}
