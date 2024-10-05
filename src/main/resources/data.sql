create table users (
                       id SERIAL PRIMARY key not NULL,
                       full_name VARCHAR(255),
                       email VARCHAR(255),
                       phone_number VARCHAR(255)
);

CREATE TABLE payment_address (
                                 id SERIAL PRIMARY key not NULL,
                                 address VARCHAR(255),
                                 user_id BIGINT,
                                 FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE pattern_payment (
                                 id SERIAL PRIMARY key not NULL,
                                 name_pattern VARCHAR(255),
                                 iban VARCHAR(34),
                                 info_about_pattern VARCHAR(255),
                                 payment_address_id BIGINT,
                                 FOREIGN KEY (payment_address_id) REFERENCES payment_address(id)
);

CREATE TABLE payment (
                         id SERIAL PRIMARY key not NULL,
                         card_number VARCHAR(20),
                         amount DECIMAL(10,2),
                         status VARCHAR(20),
                         creation_date_time TIMESTAMP,
                         status_change_date_time TIMESTAMP,
                         pattern_payment_id BIGINT,
                         FOREIGN KEY (pattern_payment_id) REFERENCES pattern_payment(id)
);