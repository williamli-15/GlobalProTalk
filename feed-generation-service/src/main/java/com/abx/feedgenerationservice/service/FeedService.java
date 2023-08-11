package com.abx.feedgenerationservice.service;

import com.abx.feedgenerationservice.model.FeedItem;
import com.abx.feedgenerationservice.repository.FeedRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<FeedItem> getFeed() {
        return feedRepository.findAll();
    }

    public FeedItem addFeed(FeedItem feedItem) {
        feedRepository.save(feedItem);
        return feedItem;
    }
}
