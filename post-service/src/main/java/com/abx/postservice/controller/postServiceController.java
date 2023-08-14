package com.abx.postservice.controller;

import com.abx.postservice.dto.PostDto;
import com.abx.postservice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class postServiceController {

    private final PostService postService;

    public postServiceController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishPost(@RequestBody PostDto postDto) {
        // validation

        if (Objects.equals(postDto.getPostName(), "")) {
            return ResponseEntity.badRequest().body("No post name provided");
        }

        String result = postService.addPost(postDto);
        // business logic service

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/publish/{post_uuid}")
    public ResponseEntity<String> deletePost(@PathVariable String postUuid) {
        // validation

        PostDto PostToDelete = null; // Write a way to retrieve Post to be deleted

        String result = postService.deletePost(PostToDelete);

        return ResponseEntity.ok(result);
    }
}
