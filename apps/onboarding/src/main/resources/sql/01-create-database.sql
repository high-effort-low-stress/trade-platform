CREATE DATABASE trade_platform;

CREATE SCHEMA onboarding;

CREATE TABLE trade_platform.onboarding.user (
    id BIGSERIAL NOT NULL,
    name VARCHAR(55) NOT NULL,
    document VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(13) NOT null,
    CONSTRAINT pk_user PRIMARY KEY (id)
);
