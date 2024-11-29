CREATE TABLE accounts
(
    id    SERIAL PRIMARY KEY,
    account_type  VARCHAR(100) NOT NULL,
    account_number VARCHAR NOT NULL UNIQUE,
    creation_date DATE NOT NULL,
    status VARCHAR(60) NOT NULL,
    client_id VARCHAR NOT NULL
);