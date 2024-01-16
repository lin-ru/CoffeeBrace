--liquibase formatted sql
--changeset author:lina.rusakova id:createTable-users dbms:postgresql
drop table IF EXISTS users CASCADE;
create TABLE users (
    id          BIGSERIAL PRIMARY KEY,
    username    VARCHAR(255) UNIQUE NOT NULL,
    email       VARCHAR(255) UNIQUE,
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    created     timestamp,
    updated     timestamp,
    password    VARCHAR(255) NOT NULL,
    status      VARCHAR(25) DEFAULT 'ACTIVE'
);