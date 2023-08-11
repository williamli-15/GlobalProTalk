package com.abx.feedgenerationservice.controller;

import com.abx.feedgenerationservice.model.FeedItem;
import com.abx.feedgenerationservice.service.FeedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FeedController {

    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feed")
    public List<FeedItem> getFeed() {
        return feedService.getFeed();
    }

    @PostMapping("/feed")
    public FeedItem addFeed(@RequestBody FeedItem feedItem) {
        return feedService.addFeed(feedItem);
    }
}
