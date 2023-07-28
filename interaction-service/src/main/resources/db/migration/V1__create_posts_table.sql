CREATE TABLE IF NOT EXISTS posts (
    post_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    create_date TIMESTAMP DEFAULT current_timestamp NOT NULL,
    update_date TIMESTAMP DEFAULT current_timestamp NOT NULL,
    is_deleted BOOLEAN DEFAULT false NOT NULL
    );

-- 添加外键约束，关联到用户表中的用户
ALTER TABLE posts ADD CONSTRAINT fk_posts_user
    FOREIGN KEY (user_id)
        REFERENCES users (user_id);