CREATE SCHEMA onboarding;

CREATE TABLE onboarding.user (
    id BIGSERIAL NOT NULL,
    name VARCHAR(55) NOT NULL,
    document VARCHAR(11) NOT NULL,
    email VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(13) NOT null,
    birth_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE UNIQUE INDEX unq_document_active ON user(document) WHERE is_active is true;
CREATE UNIQUE INDEX unq_email_active ON user(email) WHERE is_active is true;
CREATE UNIQUE INDEX unq_phone_number_active ON user(phone_number) WHERE is_active is true;
