CREATE TABLE users
(
    id        BIGSERIAL PRIMARY KEY,
    username  TEXT NOT NULL UNIQUE,
    highscore INTEGER NOT NULL
);