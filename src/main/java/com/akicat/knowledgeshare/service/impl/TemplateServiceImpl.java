package com.akicat.knowledgeshare.service.impl;

import com.akicat.knowledgeshare.eneity.TemplateEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.repository.TemplateRepository;
import com.akicat.knowledgeshare.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public List<TemplateEntity> getTemplate(String userId) {
        List<TemplateEntity> list = templateRepository.getTemplate(userId);
        if (list == null) {
            throw new BusinessFailureException();
        }
        return list;
    }

    @Override
    public void deleteTemplate(String tempId, String userId) {
        templateRepository.deleteTemplate(tempId, userId);
    }

    @Override
    public void insertTemplate(String tempContent, String userId) {
        templateRepository.insertTemplate(tempContent, userId);
    }
}
