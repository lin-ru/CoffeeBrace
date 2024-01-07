DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id          BIGSERIAL PRIMARY KEY,
    status      VARCHAR(10),
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255)
);

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS user_roles CASCADE;
CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL REFERENCES users,
    role_id BIGINT NOT NULL REFERENCES roles,
    unique (user_id, role_id)
);

