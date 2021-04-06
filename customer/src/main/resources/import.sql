CREATE SCHEMA IF NOT EXISTS customerdb ;
CREATE TABLE IF NOT EXISTS "customerdb".customer (credit_id int4 not null, first_name varchar(255), pesel int8, surname varchar(255), primary key (credit_id));
