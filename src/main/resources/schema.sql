drop table if exists categories;
create table categories(ID serial primary key, name varchar(300), created_at TIMESTAMP);

drop table if exists master_list;
create table master_list(ID serial primary key, user_id int, name varchar(300), category varchar(300), created_at TIMESTAMP);

drop table if exists shopping_list;
create table shopping_list(ID serial primary key, user_id int, name varchar(300), created_at TIMESTAMP);

drop table if exists shopping_list_item;
create table shopping_list_item(ID serial primary key, shopping_list_id int, name varchar(300), comment varchar(300),
  completed boolean, category varchar(300), created_at TIMESTAMP);

drop table if exists users;
CREATE  TABLE users (
  id serial,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled boolean NOT NULL DEFAULT true ,
  constraint "pk_users" PRIMARY KEY (username));

drop table if exists authorities;
create table authorities (
  username varchar(50) not null,
  authority varchar(50) not null);


INSERT INTO users(username,password,enabled) VALUES ('drew','$2a$10$tEelzEleqaGTC31hNZFKbeJu/SJIqBLzoO0NyWhmVce7lqLrNFQTe', true);
INSERT INTO users(username,password,enabled) VALUES ('maya','$2a$10$luBy5.QnYC3HQrFQP70Y7eqZ9yM0dJ03WsA7ERdbQ.FE5Zu5NSrSy', true);

INSERT INTO authorities (username, authority) VALUES ('drew', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('maya', 'ROLE_USER');