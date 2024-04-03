package com.akicat.knowledgeshare.repository;

import com.akicat.knowledgeshare.eneity.NoteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository {
    public List<NoteEntity> getNotes();

    List<NoteEntity> getSearchNotes(String searchContent);
    List<NoteEntity> getSearchNotesTag(String searchContent);

    NoteEntity getNoteDetail(String noteId);

    int starNote(String userId, String noteId);

    NoteEntity ifStart(String userId, String noteId);

    int unStarNote(String userId, String noteId);

    int deleteNote(String noteId);
    int deleteStarNote(String noteId);

    List<NoteEntity> getStarNotes(String userId);

    List<NoteEntity> getSearchStarNotesTag(String userId,String searchContent);

    List<NoteEntity> getSearchStarNotes(String userId,String searchContent);

    List<NoteEntity> getNotesByUser(String userId);

    void deleteUserTag(String noteTag, String userId);

    void updateTag(String noteTag, String userId,String noteId);

    List<NoteEntity> getSearchNotesTagUser(String searchContent, String userId);

    List<NoteEntity> getSearchNotesUser(String searchContent, String userId);

    List<NoteEntity> searchTagByUser(String searchContent, String userId);
}
