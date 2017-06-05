package com.amazonaws.models.nosql;

import com.amazonaws.auth.policy.actions.DynamoDBv2Actions;


import java.util.List;
import java.util.Map;
import java.util.Set;


public class VideosDO {
    private String _userId;
    private String _description;
    private String _tags;
    private String _title;
    private String _videoLink;
    private String _thumbnailLink;


    public String getUserId() {
        return _userId;
    }
    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    public String getDescription() {
        return _description;
    }

    public void setDescription(final String _description) {
        this._description = _description;
    }
    public String getTags() {
        return _tags;
    }

    public void setTags(final String _tags) {
        this._tags = _tags;
    }
    public String getTitle() {
        return _title;
    }

    public void setTitle(final String _title) {
        this._title = _title;
    }
    public String getVideoLink() {
        return _videoLink;
    }

    public void setVideoLink(final String _videoLink) {
        this._videoLink = _videoLink;
    }

    public void setThumbnailLink(final String _thumbnailLink){
        this._thumbnailLink = _thumbnailLink;
    }

}
