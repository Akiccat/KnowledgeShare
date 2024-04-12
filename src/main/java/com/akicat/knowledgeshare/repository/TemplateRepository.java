package com.akicat.knowledgeshare.repository;

import com.akicat.knowledgeshare.eneity.TemplateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository {

    List<TemplateEntity> getTemplate(String userId);

    void deleteTemplate(String tempId, String userId);

    void insertTemplate(String tempContent, String userId);
}
