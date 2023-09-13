package com.abx.postservice.dto;

import org.immutables.value.Value;

@Value.Immutable
public interface PostDto {

    String getPostName();

    String getPostUuid();

    String getUserUuid();
}
