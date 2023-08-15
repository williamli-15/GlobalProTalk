package com.abx.feedgenerationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedGenerationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedGenerationServiceApplication.class, args);
    }

    //    @Bean
    //    CommandLineRunner commandLineRunner(KafkaTemplate<String, Post> kafkaTemplate) {
    //        return args -> {
    //
    //            for (int i = 0; i < 5; i++) {
    //                Post post = new Post();
    //                post.setPostId(UUID.randomUUID());
    //                post.setAuthorId(UUID.randomUUID());
    //                post.setTitle("title-" + i);
    //                post.setContent("content-" + i);
    //                post.setLikes(123L);
    //                String partitionKey = post.getPostId().toString();
    //                kafkaTemplate.send("post-created-topic", partitionKey, post);
    //            }
    //
    //        };
    //    }
}
