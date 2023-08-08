package com.abx.interactionservice.dto;

import org.immutables.value.Value;

@Value.Immutable
public interface FavoriteResponse {
    int statusCode();
    String statusMsg();
}
