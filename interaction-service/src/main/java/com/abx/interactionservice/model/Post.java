package com.abx.interactionservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID postUuid;

    // Other fields, getters, setters, and constructors

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPostUuid() {
        return postUuid;
    }

    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
    }

    // Add other fields, getters, setters, and constructors as needed
}
