drop table categories if exists;
create table categories(ID int AUTO_INCREMENT, name varchar(300), created_at TIMESTAMP);

drop table master_list if exists;
create table master_list(ID int auto_increment, name varchar(300), category varchar(300), created_at TIMESTAMP);

drop table shopping_list if exists;
create table shopping_list(ID int AUTO_INCREMENT, name varchar(300), created_at TIMESTAMP);

drop table shopping_list_item if exists;
create table shopping_list_item(ID int AUTO_INCREMENT, shopping_list_id int, name varchar(300), comment varchar(300),
  completed boolean, category varchar(300), created_at TIMESTAMP);

drop table users if exists;
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

drop table authorities if exists;
create table authorities (
  username varchar(50) not null,
  authority varchar(50) not null);

