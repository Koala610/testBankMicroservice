CREATE KEYSPACE bank_microservice WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}  AND durable_writes = true;

CREATE TABLE bank_microservice.exchange_rates (
id BIGINT PRIMARY KEY,
first_currency decimal,
second_currency decimal,
update_date date
);