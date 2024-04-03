package com.akicat.knowledgeshare.eneity;

import java.util.Arrays;
import java.util.List;

public class FavouriteCountEntity {
    private List<String> noteTitle;
    private List<String> favouriteCount;

    public List<String> getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(List<String> noteTitle) {
        this.noteTitle = noteTitle;
    }

    public List<String> getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(List<String> favouriteCount) {
        this.favouriteCount = favouriteCount;
    }
}
