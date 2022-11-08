--liquibase formatted sql

--changeset grisha:1

CREATE SCHEMA IF NOT EXISTS tasks
    AUTHORIZATION postgres;

--changeset grisha:2
CREATE TABLE IF NOT EXISTS tasks.birthday
(
    id BIGSERIAL NOT NULL,
    create_date timestamp without time zone,
    event_time timestamp without time zone NOT NULL,
    priority integer NOT NULL,
    lastname character varying(40) COLLATE pg_catalog."default" NOT NULL,
    name character varying(40) COLLATE pg_catalog."default" NOT NULL,
    patronymic character varying(40) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT birthday_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS tasks.birthday
    OWNER to postgres;

--changeset grisha:3
CREATE TABLE IF NOT EXISTS tasks.business_meet
(
    id BIGSERIAL NOT NULL,
    create_date timestamp without time zone,
    event_time timestamp without time zone NOT NULL,
    priority integer NOT NULL,
    place character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT business_meet_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS tasks.business_meet
    OWNER to postgres

--changeset grisha:4
CREATE TABLE IF NOT EXISTS tasks.business_meet_participants
(
    business_meet_id BIGSERIAL NOT NULL,
    full_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT fk5wikud52ogmc4lcqyr358a8bk FOREIGN KEY (business_meet_id)
        REFERENCES tasks.business_meet (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS tasks.business_meet_participants
    OWNER to postgres;

--changeset grisha:5
CREATE TABLE IF NOT EXISTS tasks.flight
(
    id BIGSERIAL NOT NULL,
    create_date timestamp without time zone,
    event_time timestamp without time zone NOT NULL,
    priority integer NOT NULL,
    arriving_air_port character varying(40) COLLATE pg_catalog."default" NOT NULL,
    arriving_time timestamp without time zone NOT NULL,
    departure_airport character varying(40) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT flight_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS tasks.flight
    OWNER to postgres;


