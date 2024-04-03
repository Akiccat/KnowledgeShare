package com.akicat.knowledgeshare.eneity;

import java.util.Arrays;
import java.util.List;

public class PublishCountEntity {
    private List<String> userName;
    private List<String> publishCount;

    public List<String> getUserName() {
        return userName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    public List<String> getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(List<String> publishCount) {
        this.publishCount = publishCount;
    }
}
