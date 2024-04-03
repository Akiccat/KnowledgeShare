package com.akicat.knowledgeshare.eneity;

import java.time.LocalDateTime;

public class ReplyEntity {
    private Integer noteId;
    private Integer replyId;
    private Integer fatherReplyId;
    private Integer userId;
    private String userName;
    private Integer replyToId;
    private String replyContent;
    private LocalDateTime replyTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getFatherReplyId() {
        return fatherReplyId;
    }

    public void setFatherReplyId(Integer fatherReplyId) {
        this.fatherReplyId = fatherReplyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(Integer replyToId) {
        this.replyToId = replyToId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public LocalDateTime getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(LocalDateTime replyTime) {
        this.replyTime = replyTime;
    }
}
