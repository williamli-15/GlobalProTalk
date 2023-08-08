-- db/migration/V1__Create_Posts_Table.sql

CREATE TABLE IF NOT EXISTS posts (
    post_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    favorite_count BIGINT NOT NULL DEFAULT 0,
    comment_count BIGINT NOT NULL DEFAULT 0,
    is_favorite BOOLEAN NOT NULL DEFAULT false,
    is_deleted BOOLEAN DEFAULT false,
    created_timestamp TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_timestamp TIMESTAMP NOT NULL DEFAULT current_timestamp
    );

-- 为 user_id 和 title 添加索引，提高查询效率
CREATE INDEX idx_posts_user_id ON posts (user_id);
CREATE INDEX idx_posts_title ON posts (title);
