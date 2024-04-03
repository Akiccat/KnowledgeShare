package com.akicat.knowledgeshare.service.impl;

import com.akicat.knowledgeshare.eneity.ReplyEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.ReplyRepository;
import com.akicat.knowledgeshare.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replyMapper;
    @Override
    public List<Map<String, Object>> getReplyData(Integer noteId) {
        List<Map<String, Object>> replyList = new ArrayList<>();
        List<ReplyEntity> parentReplies = replyMapper.getRepliesByNoteId(noteId); // 获取帖子的直接回复
        // 遍历帖子的直接回复
        for (ReplyEntity parentReply : parentReplies) {
            Map<String, Object> parentReplyMap = new HashMap<>();
            // 获取子回复（递归调用）
            List<Map<String, Object>> childReplies = getChildReplies(parentReply.getReplyId());
            parentReplyMap.put("author", parentReply.getUserName());
            parentReplyMap.put("content", parentReply.getReplyContent());
            parentReplyMap.put("replyId", parentReply.getReplyId());
            parentReplyMap.put("fatherReplyId", parentReply.getFatherReplyId());
            parentReplyMap.put("children", childReplies);
            replyList.add(parentReplyMap);
        }
        return replyList;
    }

    @Override
    public void sentReply(String noteId, String replyId, String userId, String replyInputValue) {
        if(replyMapper.sentReply(noteId,replyId,userId,replyInputValue) == 0){
            throw new BusinessFailureException(true);
        }
    }

    private List<Map<String, Object>> getChildReplies(Integer fatherReplyId) {
        List<Map<String, Object>> childReplyList = new ArrayList<>();
        List<ReplyEntity> childReplies = replyMapper.getRepliesByFatherReplyId(fatherReplyId);
        // 遍历子回复
        for (ReplyEntity childReply : childReplies) {
            Map<String, Object> childReplyMap = new HashMap<>();
            // 递归获取子回复的子回复
            List<Map<String, Object>> grandChildReplies = getChildReplies(childReply.getReplyId());
            childReplyMap.put("author", childReply.getUserName());
            childReplyMap.put("content", childReply.getReplyContent());
            childReplyMap.put("children", grandChildReplies);
            childReplyMap.put("replyId", childReply.getReplyId());
            childReplyMap.put("fatherReplyId", childReply.getFatherReplyId());
            childReplyList.add(childReplyMap);
        }
        return childReplyList;
    }
}
