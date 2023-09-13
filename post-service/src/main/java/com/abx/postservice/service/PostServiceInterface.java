package com.abx.postservice.service;

import java.util.*;
import com.abx.postservice.model.Post;
import java.util.UUID;

public interface PostServiceInterface {

    List<Post> findAllPosts();


    Post createPost(Post post);

    Post updatePost(UUID uuid, Post post);

    void deletePost(UUID uuid);

    Post getPostById(UUID uugit id);


}
