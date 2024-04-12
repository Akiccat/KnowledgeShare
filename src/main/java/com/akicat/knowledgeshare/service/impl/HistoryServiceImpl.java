package com.akicat.knowledgeshare.service.impl;

import com.akicat.knowledgeshare.eneity.HistoryEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.HistoryRepository;
import com.akicat.knowledgeshare.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<HistoryEntity> getReplyHistory(String history) {
        List<HistoryEntity> list = historyRepository.getReplyHistory(history);
        if (list == null) {
            throw new BusinessFailureException();
        }
        return list;
    }

    @Override
    public void insertReplyHistory(String historyContent, String userId) {
        historyRepository.insertReplyHistory(historyContent, userId);
    }

    @Override
    public void deleteReplyHistory(String historyId, String userId) {
        historyRepository.deleteReplyHistory(historyId, userId);
    }
}
