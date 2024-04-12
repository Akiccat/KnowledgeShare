package com.akicat.knowledgeshare.request;

public class HistoryInsertRequest {
    private String userId;
    private String historyContent;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHistoryContent() {
        return historyContent;
    }

    public void setHistoryContent(String historyContent) {
        this.historyContent = historyContent;
    }
}
