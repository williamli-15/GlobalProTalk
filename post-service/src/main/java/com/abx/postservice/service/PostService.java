package com.abx.postservice.service;

import com.abx.postservice.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // inject repository name

    public String addPost(PostDto postDto) {
        // add to database
        return "Success";
    }

    public String deletePost(PostDto postDto) {
        // business logic
        // remove from db
        return "Success";
    }
}
