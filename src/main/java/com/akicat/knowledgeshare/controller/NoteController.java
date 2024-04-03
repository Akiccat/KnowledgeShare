package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.NoteEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.request.*;
import com.akicat.knowledgeshare.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("/getTagsByUser")
    public List<NoteEntity> getTagsByUser(@RequestBody StarNotesListForm starNotesListForm){
        return noteService.getTagsByUser(starNotesListForm.getUserId());
    }
    @PostMapping("/getNotes")
    public List<NoteEntity> getNoteList(){
        return noteService.getNotes();
    }
    @PostMapping("/getStarNotes")
    public List<NoteEntity> getStarNoteList(@RequestBody StarNotesListForm form){
        return noteService.getStarNotes(form.getUserId());
    }
    @PostMapping("/search")
    public List<NoteEntity> searchNoteList(@RequestBody SearchForm searchContent){
        return noteService.searchNotes(searchContent.getSearchContent());
    }
    @PostMapping("/searchStarNotes")
    public List<NoteEntity> searchStarNotes(@RequestBody SearchStarNoteForm searchContent){
        return noteService.searchStarNotes(searchContent.getUserId(),searchContent.getSearchContent());
    }
    @PostMapping("/detail")
    public NoteEntity searchNoteDetail(@RequestBody NoteDetailForm noteId){
        return noteService.noteDetail(noteId.getNoteId());
    }
    @PostMapping("/starNote")
    public void starNote(@RequestBody StarNoteRequestForm form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        noteService.starNote(form.getUserId(),form.getNoteId());
    }
    @PostMapping("/unStarNote")
    public void unStarNote(@RequestBody StarNoteRequestForm unStarForm, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        noteService.unStarNote(unStarForm.getUserId(),unStarForm.getNoteId());
    }
    @PostMapping("/ifStar")
    public NoteEntity ifStart(@RequestBody StarNoteRequestForm form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        return noteService.ifStart(form.getUserId(),form.getNoteId());
    }
    @PostMapping("/delete")
    public void deleteNote(@RequestBody StarNoteRequestForm form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        noteService.deleteNote(form.getNoteId());
    }
    @PostMapping("/updateTag")
    public void updateTag(@RequestBody NoteEntity form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        noteService.updateTag(form.getNoteTag(),form.getUserId(),form.getNoteId());
    }
    @PostMapping("/deleteTag")
    public void deleteUserTag(@RequestBody DeleteTagForm form, Errors errors){
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        noteService.deleteUserTag(form.getNoteTag(),form.getUserId());
    }
    @PostMapping("/getNoteByUser")
    public List<NoteEntity> getNoteByUserList(@RequestBody StarNotesListForm starNotesListForm){
        return noteService.getNotesByUser(starNotesListForm.getUserId());
    }

    @PostMapping("/searchNoteByUser")
    public List<NoteEntity> searchNoteByUser(@RequestBody SearchForm searchContent){
        return noteService.searchNoteByUser(searchContent.getSearchContent(),searchContent.getUserId());
    }
    @PostMapping("/searchTagByUser")
    public List<NoteEntity> searchTagByUser(@RequestBody SearchForm searchContent){
        return noteService.searchTagByUser(searchContent.getSearchContent(),searchContent.getUserId());
    }
}
