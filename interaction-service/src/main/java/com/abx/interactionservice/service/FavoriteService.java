package com.abx.interactionservice.service;

import com.abx.interactionservice.model.Post;
import com.abx.interactionservice.model.User;
import com.abx.interactionservice.repository.PostRepository;
import com.abx.interactionservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.Collections;
import java.util.UUID;

@Service
public class FavoriteService {

    private final DynamoDbClient dynamoDbClient;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public FavoriteService(DynamoDbClient dynamoDbClient, PostRepository postRepository, UserRepository userRepository) {
        this.dynamoDbClient = dynamoDbClient;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // 点赞操作
    public boolean toggleFavorite(UUID userId, UUID postUuid) {
        // 检查用户和帖子是否存在
        User user = userRepository.findByUserUuid(userId);
        Post post = postRepository.findByPostUuid(postUuid);
        if (user == null || post == null) {
            return false;
        }

        // 创建 DynamoDB 表的主键
        String compositeKey = userId.toString() + "#" + postUuid.toString();

        // 检查是否已经点赞，如果已经点赞，则取消点赞；否则，进行点赞操作
        GetItemResponse getItemResponse = dynamoDbClient.getItem(GetItemRequest.builder()
                .tableName("Favorites")
                .key(Collections.singletonMap("compositeKey", AttributeValue.builder().s(compositeKey).build()))
                .build());

        if (getItemResponse.hasItem()) {
            // 已经点赞过，进行取消点赞操作
            dynamoDbClient.deleteItem(DeleteItemRequest.builder()
                    .tableName("Favorites")
                    .key(Collections.singletonMap("compositeKey", AttributeValue.builder().s(compositeKey).build()))
                    .build());
            return true;
        } else {
            // 进行点赞操作
            dynamoDbClient.putItem(PutItemRequest.builder()
                    .tableName("Favorites")
                    .item(Collections.singletonMap("compositeKey", AttributeValue.builder().s(compositeKey).build()))
                    .build());
            return true;
        }
    }

    // 其他方法...
}
