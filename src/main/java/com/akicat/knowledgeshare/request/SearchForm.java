package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class SearchForm {
    @NotBlank(message = "搜索内容不能为空。")
    private String searchContent;
    private String userId;

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
