CREATE TABLE donor (
                       id VARCHAR(255) PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       full_name VARCHAR(255) NOT NULL
);

CREATE TABLE payment (
                         id VARCHAR(255) PRIMARY KEY,
                         date TIMESTAMP NOT NULL,
                         amount DECIMAL(10,2) NOT NULL,
                         payment_method VARCHAR(255) NOT NULL,
                         status VARCHAR(255) NOT NULL
);

CREATE TABLE donation (
                          id VARCHAR(255) PRIMARY KEY,
                          donor_id VARCHAR(255) REFERENCES donor(id),
                          payment_id VARCHAR(255) REFERENCES payment(id)
);

CREATE TABLE beneficiary (
                             id VARCHAR(255) PRIMARY KEY,
                             email VARCHAR(255) NOT NULL,
                             full_name VARCHAR(255) NOT NULL
);

CREATE TABLE help (
                      id VARCHAR(255) PRIMARY KEY,
                      beneficiary_id VARCHAR(255) REFERENCES beneficiary(id),
                      payment_id VARCHAR(255) REFERENCES payment(id),
                      accident_description TEXT NOT NULL
);