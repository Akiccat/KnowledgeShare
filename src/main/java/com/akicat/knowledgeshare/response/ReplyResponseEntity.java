package com.akicat.knowledgeshare.response;

import java.util.List;
import java.util.Map;

public class ReplyResponseEntity {
    private List<Map<String, Object>> reply;

    public List<Map<String, Object>> getReply() {
        return reply;
    }

    public void setReply(List<Map<String, Object>> reply) {
        this.reply = reply;
    }
}
