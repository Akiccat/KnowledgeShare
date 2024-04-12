package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.HistoryEntity;
import com.akicat.knowledgeshare.request.HistoryDeleteRequest;
import com.akicat.knowledgeshare.request.HistoryInsertRequest;
import com.akicat.knowledgeshare.request.HistorySearchRequest;
import com.akicat.knowledgeshare.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping("/getReplyHistory")
    public List<HistoryEntity> getReplyHistory(@RequestBody HistorySearchRequest request) {
        return historyService.getReplyHistory(request.getUserId());
    }

    @PostMapping("/deleteReplyHistory")
    public void deleteReplyHistory(@RequestBody HistoryDeleteRequest request) {
        historyService.deleteReplyHistory(request.getHistoryId(), request.getUserId());
    }

    @PostMapping("/addReplyHistory")
    public void insertReplyHistory(@RequestBody HistoryInsertRequest history) {
        historyService.insertReplyHistory(history.getHistoryContent(), history.getUserId());
    }
}
