CREATE SCHEMA onboarding;

CREATE TABLE onboarding.user (
    id BIGSERIAL NOT NULL,
    name VARCHAR(55) NOT NULL,
    document VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    phone_number VARCHAR(13) NOT null,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT unq_document_active UNIQUE (document, is_active),
    CONSTRAINT unq_email_active UNIQUE (email, is_active),
    CONSTRAINT unq_phone_number_active UNIQUE (phone_number, is_active)
);
