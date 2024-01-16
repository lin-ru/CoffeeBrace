--liquibase formatted sql
--changeset author:lina.rusakova id:createTable-roles dbms:postgresql
drop table IF EXISTS roles CASCADE;
create TABLE roles (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    created     timestamp,
    updated     timestamp,
    status      VARCHAR(25) DEFAULT 'ACTIVE'
);
