package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.ReplyEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.ReplyRepository;
import com.akicat.knowledgeshare.request.ReplyForm;
import com.akicat.knowledgeshare.request.SearchReplyForm;
import com.akicat.knowledgeshare.service.ReplyService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @PostMapping("/getReply")
    public List<Map<String, Object>> getReplyData(@RequestBody SearchReplyForm form, Errors errors) {
        if (errors.hasErrors()){
            throw new BusinessFailureException(false);
        }
        return replyService.getReplyData(Integer.valueOf(form.getNoteId()));
    }
    @PostMapping("/sentReply")
    public void sentReply(@RequestBody ReplyForm form,Errors errors) {
        if (errors.hasErrors()){
            throw new BusinessFailureException(false);
        }
        if (Objects.equals(form.getReplyId(), "")){
            form.setReplyId(null);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++"+form);
        replyService.sentReply(form.getNoteId(),form.getReplyId(),form.getUserId(),form.getReplyInputValue());
    }
}
