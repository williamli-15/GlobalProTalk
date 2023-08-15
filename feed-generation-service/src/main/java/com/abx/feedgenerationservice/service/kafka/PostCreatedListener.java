package com.abx.feedgenerationservice.service.kafka;

import com.abx.feedgenerationservice.model.Post;
import com.abx.feedgenerationservice.service.FeedGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PostCreatedListener {

    private final FeedGeneratorService feedGeneratorService;

    @Autowired
    public PostCreatedListener(FeedGeneratorService feedGeneratorService) {
        this.feedGeneratorService = feedGeneratorService;
    }

    @KafkaListener(topics = "post-created-topic", groupId = "group-post-created")
    public void listenToPartition(@Payload Post post, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        //        System.out.println("post: " + post + " from partition: " + partition);
        feedGeneratorService.addToFeed(post);
    }
}
