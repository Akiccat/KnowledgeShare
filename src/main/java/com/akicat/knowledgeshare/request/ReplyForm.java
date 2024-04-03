package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class ReplyForm {
    @NotBlank
    private String noteId;
    private String replyId;
    @NotBlank
    private String replyInputValue;
    @NotBlank
    private String userId;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyInputValue() {
        return replyInputValue;
    }

    public void setReplyInputValue(String replyInputValue) {
        this.replyInputValue = replyInputValue;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReplyForm{" +
                "noteId='" + noteId + '\'' +
                ", replyId='" + replyId + '\'' +
                ", replyInputValue='" + replyInputValue + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
