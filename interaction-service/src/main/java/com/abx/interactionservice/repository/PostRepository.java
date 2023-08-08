package com.abx.interactionservice.repository;

import com.abx.interactionservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByPostUuid(UUID postUuid);
}
