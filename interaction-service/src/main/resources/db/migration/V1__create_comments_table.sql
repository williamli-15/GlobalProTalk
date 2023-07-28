-- db/migration/V1__create_comments_table.sql

CREATE TABLE IF NOT EXISTS comments (
    comment_id SERIAL PRIMARY KEY,
    post_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    content TEXT NOT NULL,
    create_date TIMESTAMP NOT NULL,
    is_deleted BOOLEAN DEFAULT false
);

-- 添加外键约束，关联到帖子表中的帖子
ALTER TABLE comments ADD CONSTRAINT fk_comments_post
    FOREIGN KEY (post_id)
        REFERENCES posts (post_id);

-- 添加外键约束，关联到用户表中的用户
ALTER TABLE comments ADD CONSTRAINT fk_comments_user
    FOREIGN KEY (user_id)
        REFERENCES users (user_id);
