// FavoriteController.java
package com.abx.interactionservice.controller;

import com.abx.interactionservice.dto.FavoriteActionRequestDTO;
import com.abx.interactionservice.dto.FavoriteActionResponseDTO;
import com.abx.interactionservice.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorite/action")
    public FavoriteActionResponseDTO favoriteAction(@RequestBody FavoriteActionRequestDTO requestDTO) {
        // 调用 service 处理赞操作逻辑
        return favoriteService.handleFavoriteAction(requestDTO);
    }
}
