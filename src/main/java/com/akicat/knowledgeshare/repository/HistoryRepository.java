package com.akicat.knowledgeshare.repository;

import com.akicat.knowledgeshare.eneity.HistoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository {

    List<HistoryEntity> getReplyHistory(String userId);

    void insertReplyHistory(String historyContent, String userId);

    void deleteReplyHistory(String historyId, String userId);
}
