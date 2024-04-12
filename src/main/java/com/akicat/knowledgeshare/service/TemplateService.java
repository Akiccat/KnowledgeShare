package com.akicat.knowledgeshare.service;

import com.akicat.knowledgeshare.eneity.TemplateEntity;

import java.util.List;

public interface TemplateService {
    List<TemplateEntity> getTemplate(String userId);

    void deleteTemplate(String tempId, String userId);

    void insertTemplate(String tempContent, String userId);
}
