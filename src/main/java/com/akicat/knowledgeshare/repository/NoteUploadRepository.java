package com.akicat.knowledgeshare.repository;

import com.akicat.knowledgeshare.eneity.NoteEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteUploadRepository {
    int uploadNote(NoteEntity note);

    int updateNote(NoteEntity note);
}
