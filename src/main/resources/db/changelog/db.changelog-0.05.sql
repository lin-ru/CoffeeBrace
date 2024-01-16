--liquibase formatted sql
--changeset author:lina.rusakova id: write-data-admin-user dbms:postgresql
INSERT INTO users (id, status, password, username) VALUES (1, 'ACTIVE','$2a$12$gRpj0xAFrMqa7J2FBhyxBeQO5cT..lEsvkDzvwFXPakJvj22WZJdu', 'admin');
INSERT INTO users (id, status, password, username) VALUES (2, 'ACTIVE','$2a$12$7iAiDkrf8TkCyy3NOYXvH.UhS/izI72cGGpLAYzUHzQHwaOUcvIHS', 'user');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);