package com.akicat.knowledgeshare.eneity;

public class NoteEntity {
    private String noteTitle;
    private String noteSimpleContent;
    private String noteContent;
    private String noteTag;
    private String noteId;
    private String userId;
    private String userName;
    private String noteCover;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNoteCover() {
        return noteCover;
    }

    public void setNoteCover(String noteCover) {
        this.noteCover = noteCover;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteSimpleContent() {
        return noteSimpleContent;
    }

    public void setNoteSimpleContent(String noteSimpleContent) {
        this.noteSimpleContent = noteSimpleContent;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteTag() {
        return noteTag;
    }

    public void setNoteTag(String noteTag) {
        this.noteTag = noteTag;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "noteTitle='" + noteTitle + '\'' +
                ", noteSimpleContent='" + noteSimpleContent + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", noteTag='" + noteTag + '\'' +
                ", noteId='" + noteId + '\'' +
                ", userId='" + userId + '\'' +
                ", noteCover='" + noteCover + '\'' +
                '}';
    }
}
