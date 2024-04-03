package com.akicat.knowledgeshare.repository;

import com.akicat.knowledgeshare.eneity.ReplyCountEntity;
import com.akicat.knowledgeshare.eneity.UserFromEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisualizationRepository {
    List<String> getPublishCountName();
    List<String> getPublishCount();

    List<String> getFavouriteCountName();
    List<String> getFavouriteCount();

    List<UserFromEntity> getUserFrom();
    List<ReplyCountEntity> getReplyCount();
}
