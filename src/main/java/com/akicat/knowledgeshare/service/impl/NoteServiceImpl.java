package com.akicat.knowledgeshare.service.impl;

import com.akicat.knowledgeshare.eneity.NoteEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.NoteRepository;
import com.akicat.knowledgeshare.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    public List<NoteEntity> getNotes(){
        if (noteRepository.getNotes() == null){
            throw new BusinessFailureException(true);
        }
        return noteRepository.getNotes();
    }

    @Override
    public List<NoteEntity> searchNotes(String searchContent) {
        if (searchContent.startsWith("#")) {
            // 去掉 '#'，留下 tag
            searchContent = searchContent.substring(1);
            if (noteRepository.getSearchNotesTag(searchContent) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchNotesTag(searchContent);
        }else {
            if (noteRepository.getSearchNotes(searchContent) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchNotes(searchContent);
        }
    }

    @Override
    public NoteEntity noteDetail(String noteId) {
        return noteRepository.getNoteDetail(noteId);
    }

    @Override
    public void starNote(String userId, String noteId) {
        if (noteRepository.starNote(userId,noteId) != 1){
            throw new BusinessFailureException(true);
        }
    }
    @Override
    public void unStarNote(String userId, String noteId) {
        if (noteRepository.unStarNote(userId,noteId) == 0){
            throw new BusinessFailureException(true);
        }
    }

    @Override
    public void deleteNote(String noteId) {
        if (noteRepository.deleteNote(noteId) != 1 || noteRepository.deleteStarNote(noteId) == 0){
            throw new BusinessFailureException(true);
        }
    }

    @Override
    public List<NoteEntity> getStarNotes(String userId) {
        if (noteRepository.getStarNotes(userId) == null){
            throw new BusinessFailureException(true);
        }
        return noteRepository.getStarNotes(userId);
    }

    @Override
    public List<NoteEntity> searchStarNotes(String userId, String searchContent) {
        if (searchContent.startsWith("#")) {
            // 去掉 '#'，留下 tag
            searchContent = searchContent.substring(1);
            if (noteRepository.getSearchStarNotesTag(userId,searchContent) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchStarNotesTag(userId,searchContent);
        }else {
            if (noteRepository.getSearchStarNotes(userId,searchContent) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchStarNotes(userId,searchContent);
        }
    }

    @Override
    public List<NoteEntity> getNotesByUser(String userId) {
        List<NoteEntity> notes = noteRepository.getNotesByUser(userId);
        if (notes == null){
            throw new BusinessFailureException(true);
        }
        return notes;
    }

    @Override
    public List<NoteEntity> getTagsByUser(String userId) {
        List<NoteEntity> notes = noteRepository.getNotesByUser(userId);
        List<NoteEntity> filterNotes = new ArrayList<>();
        Set<String> uniqueTags = new HashSet<>();
        if (notes == null){
            throw new BusinessFailureException(true);
        }
        for (NoteEntity note : notes) {
            if (uniqueTags.add(note.getNoteTag())) { // 添加成功说明是一个新的Tag
                filterNotes.add(note);
            }
        }
        return filterNotes;
    }

    @Override
    public void deleteUserTag(String noteTag, String userId) {
        noteRepository.deleteUserTag(noteTag, userId);
    }

    @Override
    public void updateTag(String noteTag, String userId,String noteId) {
        noteRepository.updateTag(noteTag,userId,noteId);
    }

    @Override
    public List<NoteEntity> searchNoteByUser(String searchContent, String userId) {
        if (searchContent.startsWith("#")) {
            // 去掉 '#'，留下 tag
            searchContent = searchContent.substring(1);
            if (noteRepository.getSearchNotesTagUser(searchContent,userId) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchNotesTagUser(searchContent,userId);
        }else {
            if (noteRepository.getSearchNotesUser(searchContent,userId) == null){
                throw new BusinessFailureException(true);
            }
            return noteRepository.getSearchNotesUser(searchContent,userId);
        }
    }

    @Override
    public List<NoteEntity> searchTagByUser(String searchContent, String userId) {
        List<NoteEntity> notes = noteRepository.searchTagByUser(searchContent,userId);
        List<NoteEntity> filterNotes = new ArrayList<>();
        Set<String> uniqueTags = new HashSet<>();
        if (notes == null){
            throw new BusinessFailureException(true);
        }
        for (NoteEntity note : notes) {
            if (uniqueTags.add(note.getNoteTag())) { // 添加成功说明是一个新的Tag
                filterNotes.add(note);
            }
        }
        return filterNotes;
    }

    @Override
    public NoteEntity ifStart(String userId, String noteId) {
        if (noteRepository.ifStart(userId,noteId) == null){
            throw new BusinessFailureException(true);
        }else {
            return noteRepository.ifStart(userId,noteId);
        }
    }
}
