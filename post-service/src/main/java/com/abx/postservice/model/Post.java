package com.abx.postservice.model;

import jakarta.persistence.*;

import java.persistence.Entity;
import java.persistence.Id;
import java.security.Timestamp;
import java.util.UUID;

@Entity
public class Post {
    @Id
    private UUID postUuid;

    private String title;

    private String content;

    private Timestamp date;

    private int like;  // number of likes

    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addLike() {
        this.like++;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public UUID getPostUuid() {
        return postUuid;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLike(){
        return like;
    }

    public Timestamp getDate() {
        return date;
    }

}