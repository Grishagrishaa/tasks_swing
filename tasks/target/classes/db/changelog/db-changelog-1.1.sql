--liquibase formatted sql

--changeset grisha:1

CREATE SEQUENCE IF NOT EXISTS tasks.hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE tasks.hibernate_sequence
    OWNER TO postgres;