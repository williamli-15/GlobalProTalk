package com.abx.interactionservice.controller;

import com.abx.interactionservice.dto.FavoriteResponse;
import com.abx.interactionservice.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorite/{postUuid}")
    public FavoriteResponse favoritePost(@PathVariable String postUuid, @RequestHeader("token") String token) {
        UUID postUUID = UUID.fromString(postUuid);
        UUID userUUID = UUID.fromString(token);

        boolean success = favoriteService.toggleFavorite(userUUID, postUUID);
        if (success) {
            return ImmutableFavoriteResponse.builder()
                    .statusCode(0)
                    .statusMsg("操作成功")
                    .build();
        } else {
            return ImmutableFavoriteResponse.builder()
                    .statusCode(1)
                    .statusMsg("操作失败")
                    .build();
        }
    }
}
