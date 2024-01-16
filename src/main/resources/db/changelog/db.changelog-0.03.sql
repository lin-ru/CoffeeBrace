--liquibase formatted sql
--changeset author:lina.rusakova id:createTable-user_roles dbms:postgresql
drop table IF EXISTS user_roles CASCADE;
create TABLE user_roles (
    user_id BIGINT NOT NULL REFERENCES users,
    role_id BIGINT NOT NULL REFERENCES roles,
    unique (user_id, role_id)
);
