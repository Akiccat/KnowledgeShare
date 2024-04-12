package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.TemplateEntity;
import com.akicat.knowledgeshare.request.TemplateDeleteRequest;
import com.akicat.knowledgeshare.request.TemplateInsertRequest;
import com.akicat.knowledgeshare.request.TemplateSearchRequest;
import com.akicat.knowledgeshare.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @PostMapping("/getTemplate")
    public List<TemplateEntity> getTemplate(@RequestBody TemplateSearchRequest request) {
        return templateService.getTemplate(request.getUserId());
    }

    @PostMapping("/deleteTemplate")
    public void deleteTemplate(@RequestBody TemplateDeleteRequest request) {
        templateService.deleteTemplate(request.getTempId(), request.getUserId());
    }

    @PostMapping("/addTemplate")
    public void insertTemplate(@RequestBody TemplateInsertRequest history) {
        templateService.insertTemplate(history.getTempContent(), history.getUserId());
    }
}
