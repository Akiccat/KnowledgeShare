package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.FavouriteCountEntity;
import com.akicat.knowledgeshare.eneity.PublishCountEntity;
import com.akicat.knowledgeshare.eneity.ReplyCountEntity;
import com.akicat.knowledgeshare.eneity.UserFromEntity;
import com.akicat.knowledgeshare.repository.VisualizationRepository;
import net.dreamlu.mica.core.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VisualizationController {
    @Autowired
    private VisualizationRepository visualizationRepository;

    @PostMapping("/getPublishCount")
    public PublishCountEntity getPublishCount(){
        PublishCountEntity publishCountEntity = new PublishCountEntity();
        publishCountEntity.setPublishCount(visualizationRepository.getPublishCount());
        publishCountEntity.setUserName(visualizationRepository.getPublishCountName());
        return publishCountEntity;
    }
    @PostMapping("/getUserFrom")
    public List<UserFromEntity> getUserFrom(){
        return visualizationRepository.getUserFrom();
    }

    @PostMapping("/getReplyCount")
    public List<ReplyCountEntity> getReplyCount(){
        return visualizationRepository.getReplyCount();
    }
    @PostMapping("/getFavouriteCount")
    public FavouriteCountEntity getFavouriteCount(){
        FavouriteCountEntity favouriteCountEntity = new FavouriteCountEntity();
        favouriteCountEntity.setFavouriteCount(visualizationRepository.getFavouriteCount());
        favouriteCountEntity.setNoteTitle(visualizationRepository.getFavouriteCountName());
        return favouriteCountEntity;
    }
}
