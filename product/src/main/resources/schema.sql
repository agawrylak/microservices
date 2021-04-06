CREATE SCHEMA productdb IF NOT EXISTS;
create table "productdb".product (credit_id int4 not null, product_name varchar(255), value int4, primary key (credit_id)) IF NOT EXISTS;
