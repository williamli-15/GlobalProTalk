CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    password_salt VARCHAR(64) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    avatar VARCHAR(255),
    signature TEXT,
    create_date TIMESTAMP DEFAULT current_timestamp NOT NULL,
    update_date TIMESTAMP DEFAULT current_timestamp NOT NULL
);
