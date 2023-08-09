CREATE KEYSPACE IF NOT EXISTS feed_generation_service_cassandra
    WITH replication = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
    };

USE "feed_generation_service_cassandra";

CREATE TABLE IF NOT EXISTS "user_feed" (
    user_id uuid,
    added_at timestamp,
    post_id uuid,
    title varchar,
    content text,
    likes bigint,
    username varchar,
    avatar varchar,
    PRIMARY KEY (user_id, added_at, post_id)
) WITH CLUSTERING ORDER BY (added_at DESC, post_id ASC);