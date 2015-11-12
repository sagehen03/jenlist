drop table categories if exists;
create table categories(ID int AUTO_INCREMENT, name varchar(300), created_at TIMESTAMP);

drop table master_list if exists;
create table master_list(ID int auto_increment, name varchar(300), category varchar(300), created_at TIMESTAMP);

drop table shopping_list if exists;
create table shopping_list(ID int AUTO_INCREMENT, name varchar(300), created_at TIMESTAMP);

drop table shopping_list_item if exists;
create table shopping_list_item(ID int AUTO_INCREMENT, shopping_list_id int, name varchar(300), comment varchar(300), completed boolean,
created_at TIMESTAMP);
