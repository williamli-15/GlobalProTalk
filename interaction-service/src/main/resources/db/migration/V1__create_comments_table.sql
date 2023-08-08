-- db/migration/V1__create_comments_table.sql

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS comments (
    comment_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    post_id UUID NOT NULL,
    user_id UUID NOT NULL,
    content TEXT NOT NULL,
    created_timestamp TIMESTAMP DEFAULT current_timestamp,
    updated_timestamp TIMESTAMP DEFAULT current_timestamp,
    is_deleted BOOLEAN DEFAULT false
    );

CREATE INDEX ON comments (post_id);
CREATE INDEX ON comments (user_id);