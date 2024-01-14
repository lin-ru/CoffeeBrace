--liquibase formatted sql
--changeset author:lina.rusakova id:createTable-users dbms:postgresql
drop table IF EXISTS users CASCADE;
create TABLE users (
    id          BIGSERIAL PRIMARY KEY,
    username    VARCHAR(255) UNIQUE NOT NULL,
    email       VARCHAR(255) UNIQUE,
    fisrt_name  VARCHAR(255),
    last_name   VARCHAR(255),
    created     timestamp CURRENT_TIMESTAMP,
    updated     timestamp CURRENT_TIMESTAMP,
    password    VARCHAR(255) NOT NULL,
    status      VARCHAR(25) DEFAULT 'ACTIVE'
);

--changeset author:lina.rusakova id:createTable-roles dbms:postgresql
drop table IF EXISTS roles CASCADE;
create TABLE roles (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    created     timestamp CURRENT_TIMESTAMP,
    updated     timestamp CURRENT_TIMESTAMP,
    status      VARCHAR(25) DEFAULT 'ACTIVE'
);

--changeset author:lina.rusakova id:createTable-user_roles dbms:postgresql
drop table IF EXISTS user_roles CASCADE;
create TABLE user_roles (
    user_id BIGINT NOT NULL REFERENCES users,
    role_id BIGINT NOT NULL REFERENCES roles,
    unique (user_id, role_id)
);

