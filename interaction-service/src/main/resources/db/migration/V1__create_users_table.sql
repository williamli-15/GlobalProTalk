-- db/migration/V1__Create_Users_Table.sql

CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR(50) UNIQUE NOT NULL,
    follow_count BIGINT NOT NULL DEFAULT 0,
    follower_count BIGINT NOT NULL DEFAULT 0,
    is_follow BOOLEAN NOT NULL DEFAULT false,
    avatar VARCHAR(255),
    background_image VARCHAR(255),
    signature TEXT,
    total_favorited BIGINT NOT NULL DEFAULT 0,
    post_count BIGINT NOT NULL DEFAULT 0,
    favorite_count BIGINT NOT NULL DEFAULT 0,
    created_timestamp TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_timestamp TIMESTAMP NOT NULL DEFAULT current_timestamp
    );

-- 为 name 添加索引，提高查询效率
CREATE INDEX idx_users_name ON users (username);
