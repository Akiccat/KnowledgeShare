package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class StarNoteRequestForm {
    @NotBlank(message = "用户ID不能为空。")
    private String userId;
    @NotBlank(message = "笔记ID不能为空。")
    private String noteId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }
}
