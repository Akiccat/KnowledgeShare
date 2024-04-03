package com.akicat.knowledgeshare.eneity;

import java.util.List;

public class NoteCountEntity {
    private List<Integer> userName;
    private List<Integer> publishCount;

    public List<Integer> getUserName() {
        return userName;
    }

    public void setUserName(List<Integer> userName) {
        this.userName = userName;
    }

    public List<Integer> getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(List<Integer> publishCount) {
        this.publishCount = publishCount;
    }

    @Override
    public String toString() {
        return "NoteCountEntity{" +
                "userName=" + userName +
                ", publishCount=" + publishCount +
                '}';
    }
}
