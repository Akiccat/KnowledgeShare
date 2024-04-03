package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class NoteDetailForm {
    @NotBlank(message = "id不能为空")
    private String noteId;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }
}
