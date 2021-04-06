CREATE SCHEMA IF NOT EXISTS creditdb;
CREATE TABLE IF NOT EXISTS "creditdb".credit (creditid  serial not null, credit_name varchar(255), primary key (creditid))