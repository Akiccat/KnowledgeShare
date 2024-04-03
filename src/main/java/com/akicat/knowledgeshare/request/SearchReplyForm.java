package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class SearchReplyForm {
    @NotBlank
    private String noteId;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }
}
