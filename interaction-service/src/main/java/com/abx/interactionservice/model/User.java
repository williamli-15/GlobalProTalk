package com.abx.interactionservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {
    @Id
    private UUID userUuid;

    // Other fields, getters, setters, and constructors

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    // Add other fields, getters, setters, and constructors as needed
}
