package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class SearchStarNoteForm {
    @NotBlank
    String userId;
    @NotBlank
    String searchContent;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }
}
