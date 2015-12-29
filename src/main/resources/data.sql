insert into categories(name, created_at) values ('Produce', current_timestamp);
insert into categories(name, created_at) values ('Bakery', current_timestamp);
insert into categories(name, created_at) values ('Cereal', current_timestamp);
insert into categories(name, created_at) values ('Dairy', current_timestamp);
insert into categories(name, created_at) values ('Crackers', current_timestamp);
insert into categories(name, created_at) values ('Baking', current_timestamp);
insert into categories(name, created_at) values ('Frozen Foods', current_timestamp);
insert into categories(name, created_at) values ('Butcher', current_timestamp);
insert into categories(name, created_at) values ('Prepared Foods', current_timestamp);


insert into master_list(name, category, created_at, user_id) values('Tomatoes', 'Produce', CURRENT_TIMESTAMP,1);
insert into master_list(name, category, created_at, user_id) values('Green Beans', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('French Bread', 'Bakery', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Chicken', 'Butcher', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Avocadoes', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Milk', 'Dairy', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Peanut Butter', 'Prepared Foods', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Sandwich bread', 'Bakery', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Jelly', 'Prepared Foods', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Cumin', 'Baking', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Chili Powder', 'Baking', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Bay Leaves', 'Baking', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Thyme', 'Baking', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Oregano', 'Baking', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Cilantro', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Italian Parsley', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Kale', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Blood Oranges', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Plums', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Apples', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Grapes', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Grapefruit', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Blueberries', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Strawberries', 'Produce', CURRENT_TIMESTAMP,1);
insert into master_list(name, category, created_at, user_id) values('Raspberries', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Black berries', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Bananas', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Broccoli', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Spinach', 'Produce', CURRENT_TIMESTAMP, 1);
insert into master_list(name, category, created_at, user_id) values('Celery', 'Produce', CURRENT_TIMESTAMP, 2);
insert into master_list(name, category, created_at, user_id) values('Napa Cabbage', 'Produce', CURRENT_TIMESTAMP, 2);
insert into master_list(name, category, created_at, user_id) values('Escarole', 'Produce', CURRENT_TIMESTAMP, 2);

insert into shopping_list(name, created_at, user_id) values('Whole Foods List', CURRENT_TIMESTAMP, 1);
insert into shopping_list(name, created_at, user_id) values('Trader Joe''s List', CURRENT_TIMESTAMP, 1);

insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Tomatoes', '3', false, 'Produce', CURRENT_TIMESTAMP);
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Milk', 'Organic non-fat', false, 'Dairy', CURRENT_TIMESTAMP);
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Green Beans', 'half pound', false, 'Produce', CURRENT_TIMESTAMP);
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
(2, 'Avocadoes', 'Haas', false, 'Produce', CURRENT_TIMESTAMP);



