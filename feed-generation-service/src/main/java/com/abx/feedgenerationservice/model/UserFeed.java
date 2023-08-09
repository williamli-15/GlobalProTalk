package com.abx.feedgenerationservice.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user_feed")
@Data
@Builder
@ToString
public class UserFeed {
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID userId;

    @Column("username")
    private String username;

    @Column("avatar")
    private String avatar;

    @PrimaryKeyColumn(name = "added_at", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Instant addedAt;

    @PrimaryKeyColumn(name = "post_id", ordinal = 2)
    private UUID postId;

    @Column("title")
    private String title;

    @Column("content")
    private String content;

    @Column("likes")
    private long likes;
}
