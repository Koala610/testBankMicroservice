CREATE TABLE bank_microservice.exchange_rates (
id BIGINT PRIMARY KEY,
first_currency varchar,
second_currency varchar,
value decimal,
timestamp timestamp
);
