package com.abx.interactionservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Post {
    @Id
    private UUID postUuid;

    // Other fields, getters, setters, and constructors

    public UUID getPostUuid() {
        return postUuid;
    }

    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
    }

    // Add other fields, getters, setters, and constructors as needed
}
