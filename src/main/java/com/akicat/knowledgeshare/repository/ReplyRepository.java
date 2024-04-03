package com.akicat.knowledgeshare.repository;


import com.akicat.knowledgeshare.eneity.ReplyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository {
    ReplyEntity getReplyById(Integer replyId);
    List<ReplyEntity> getRepliesByNoteId(Integer noteId);
    List<ReplyEntity> getRepliesByFatherReplyId(Integer fatherReplyId);


    int sentReply(String noteId, String replyId, String userId, String replyInputValue);
}
