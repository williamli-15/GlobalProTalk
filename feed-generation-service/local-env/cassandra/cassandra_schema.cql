CREATE KEYSPACE IF NOT EXISTS feed_generation_service_cassandra
    WITH replication = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
    };

USE "feed_generation_service_cassandra";

CREATE TABLE IF NOT EXISTS "feed_item" (
    user_id uuid,
    created_at timestamp,
    post_id uuid,
    title varchar,
    content text,
    likes bigint,
    author_id uuid,
    username varchar,
    avatar varchar,
    PRIMARY KEY (user_id, created_at, post_id)
) WITH CLUSTERING ORDER BY (created_at DESC, post_id ASC);