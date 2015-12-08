insert into categories(name, created_at) values ('Produce', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Bakery', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Cereal', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Dairy', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Crackers', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Baking', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Frozen Foods', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Butcher', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Prepared Foods', CURRENT_TIMESTAMP());

INSERT INTO users(username,password,enabled)
VALUES ('drew','$2a$10$tEelzEleqaGTC31hNZFKbeJu/SJIqBLzoO0NyWhmVce7lqLrNFQTe', true);

INSERT INTO users(username,password,enabled)
VALUES ('jen','$2a$10$tEelzEleqaGTC31hNZFKbeJu/SJIqBLzoO0NyWhmVce7lqLrNFQTe', true);

INSERT INTO authorities (username, authority) VALUES ('drew', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('jen', 'ROLE_USER');

insert into master_list(name, category, created_at, user_id) values('Tomatoes', 'Produce', CURRENT_TIMESTAMP(),1);
insert into master_list(name, category, created_at, user_id) values('Green Beans', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('French Bread', 'Bakery', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Chicken', 'Butcher', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Avocadoes', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Milk', 'Dairy', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Peanut Butter', 'Prepared Foods', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Sandwich bread', 'Bakery', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Jelly', 'Prepared Foods', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Cumin', 'Baking', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Chili Powder', 'Baking', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Bay Leaves', 'Baking', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Thyme', 'Baking', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Oregano', 'Baking', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Cilantro', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Italian Parsley', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Kale', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Blood Oranges', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Plums', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Apples', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Grapes', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Grapefruit', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Blueberries', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Strawberries', 'Produce', CURRENT_TIMESTAMP(),1);
insert into master_list(name, category, created_at, user_id) values('Raspberries', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Black berries', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Bananas', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Broccoli', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Spinach', 'Produce', CURRENT_TIMESTAMP(), 1);
insert into master_list(name, category, created_at, user_id) values('Celery', 'Produce', CURRENT_TIMESTAMP(), 2);
insert into master_list(name, category, created_at, user_id) values('Napa Cabbage', 'Produce', CURRENT_TIMESTAMP(), 2);
insert into master_list(name, category, created_at, user_id) values('Escarole', 'Produce', CURRENT_TIMESTAMP(), 2);

insert into shopping_list(name, created_at, user_id) values('Whole Foods List', CURRENT_TIMESTAMP(), 1);
insert into shopping_list(name, created_at, user_id) values('Trader Joe''s List', CURRENT_TIMESTAMP(), 1);

insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Tomatoes', '3', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Milk', 'Organic non-fat', false, 'Dairy', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Green Beans', 'half pound', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
(2, 'Avocadoes', 'Haas', false, 'Produce', CURRENT_TIMESTAMP());



