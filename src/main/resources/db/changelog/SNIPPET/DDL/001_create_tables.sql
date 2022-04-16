--liquibase formatted sql
--changeset jhaldimann:create-tables-v2

DROP TABLE IF EXISTS snippet;
DROP TABLE IF EXISTS member;

CREATE TABLE snippet(
    ID VARCHAR PRIMARY KEY,
    TEXT VARCHAR(255),
    CATEGORY VARCHAR(255),
    LANGUAGE VARCHAR(255),
    USERID VARCHAR(255)
);

CREATE TABLE member(
    ID VARCHAR PRIMARY KEY,
    USERNAME VARCHAR(255)
);