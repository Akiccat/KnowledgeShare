package com.akicat.knowledgeshare.service;

import java.util.List;
import java.util.Map;

public interface ReplyService {
    public List<Map<String, Object>> getReplyData(Integer noteId);

    void sentReply(String noteId, String replyId, String userId, String replyInputValue);
}
