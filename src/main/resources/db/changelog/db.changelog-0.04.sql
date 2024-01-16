--liquibase formatted sql
--changeset author:lina.rusakova id:createTable-cards dbms:postgresql
drop table IF EXISTS cards CASCADE;
create TABLE cards (
    card_id     UUID PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created     timestamp,
    updated     timestamp,
    status      VARCHAR(25) DEFAULT 'ACTIVE'
);
