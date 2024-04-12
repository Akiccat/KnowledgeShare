package com.akicat.knowledgeshare.service;

import com.akicat.knowledgeshare.eneity.HistoryEntity;

import java.util.List;

public interface HistoryService {
    List<HistoryEntity> getReplyHistory(String userId);

    void insertReplyHistory(String historyContent, String userId);

    void deleteReplyHistory(String historyId, String userId);
}
