package com.akicat.knowledgeshare.request;

public class DeleteTagForm {
    private String noteTag;
    private String userId;

    public String getNoteTag() {
        return noteTag;
    }

    public void setNoteTag(String noteTag) {
        this.noteTag = noteTag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
