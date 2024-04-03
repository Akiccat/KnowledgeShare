package com.akicat.knowledgeshare.service;

import com.akicat.knowledgeshare.eneity.NoteEntity;

import java.util.List;

public interface NoteService {
    public List<NoteEntity> getNotes();

    List<NoteEntity> searchNotes(String searchContent);

    NoteEntity noteDetail(String noteId);

    void starNote(String userId, String noteId);

    NoteEntity ifStart(String userId, String noteId);

    void unStarNote(String userId, String noteId);

    void deleteNote(String noteId);

    List<NoteEntity> getStarNotes(String userId);

    List<NoteEntity> searchStarNotes(String userId,String searchContent);

    List<NoteEntity> getNotesByUser(String userId);

    List<NoteEntity> getTagsByUser(String userId);

    void deleteUserTag(String noteTag, String userId);

    void updateTag(String noteTag, String userId, String noteId);

    List<NoteEntity> searchNoteByUser(String searchContent, String userId);

    List<NoteEntity> searchTagByUser(String searchContent, String userId);
}
