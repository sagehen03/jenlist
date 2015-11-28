insert into categories(name, created_at) values ('Produce', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Bakery', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Cereal', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Dairy', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Crackers', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Baking', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Frozen Foods', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Butcher', CURRENT_TIMESTAMP());
insert into categories(name, created_at) values ('Prepared Foods', CURRENT_TIMESTAMP());

insert into master_list(name, category, created_at) values('Tomatoes', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Green Beans', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('French Bread', 'Bakery', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Chicken', 'Butcher', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Avocadoes', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Milk', 'Dairy', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Peanut Butter', 'Prepared Foods', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Sandwich bread', 'Bakery', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Jelly', 'Prepared Foods', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Cumin', 'Baking', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Chili Powder', 'Baking', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Bay Leaves', 'Baking', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Thyme', 'Baking', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Oregano', 'Baking', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Cilantro', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Italian Parsley', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Kale', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Blood Oranges', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Plums', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Apples', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Grapes', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Grapefruit', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Blueberries', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Strawberries', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Raspberries', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Black berries', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Bananas', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Broccoli', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Spinach', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Celery', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Napa Cabbage', 'Produce', CURRENT_TIMESTAMP());
insert into master_list(name, category, created_at) values('Escarole', 'Produce', CURRENT_TIMESTAMP());

insert into shopping_list(name, created_at) values('Whole Foods List', CURRENT_TIMESTAMP());
insert into shopping_list(name, created_at) values('Trader Joe''s List', CURRENT_TIMESTAMP());

insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Tomatoes', '3', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Milk', 'Organic non-fat', false, 'Dairy', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Green Beans', 'half pound', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
(2, 'Avocadoes', 'Haas', false, 'Produce', CURRENT_TIMESTAMP());

INSERT INTO users(username,password,enabled)
VALUES ('mkyong','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', true);

INSERT INTO authorities (username, authority) VALUES ('mkyong', 'ROLE_USER');

INSERT INTO authorities (username, authority) VALUES ('mkyong', 'ROLE_ADMIN');
