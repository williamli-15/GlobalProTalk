package com.abx.feedgenerationservice.service;

import com.abx.feedgenerationservice.model.Post;
import com.abx.feedgenerationservice.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedGeneratorService {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedGeneratorService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public void addToFeed(Post post) {
        System.out.println("adding post " + post + " to cassandra database...");
        // feedRepository.save()
    }
}
