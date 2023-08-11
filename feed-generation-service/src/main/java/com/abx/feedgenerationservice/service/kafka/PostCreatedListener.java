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

    private final String POST_CREATED_TOPIC = "post-created-topic";
    private final FeedGeneratorService feedGeneratorService;

    @Autowired
    public PostCreatedListener(FeedGeneratorService feedGeneratorService) {
        this.feedGeneratorService = feedGeneratorService;
    }

    @KafkaListener(topics = POST_CREATED_TOPIC, groupId = "group-post-created")
    public void listenToPartition(@Payload Post post, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        System.out.println("post: " + post + " from partition: " + partition);
        feedGeneratorService.addToFeed(post);
    }
}
