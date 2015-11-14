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

insert into shopping_list(name, created_at) values('Whole Foods List', CURRENT_TIMESTAMP());
insert into shopping_list(name, created_at) values('Trader Joe''s List', CURRENT_TIMESTAMP());

insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Tomatoes', '3', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Milk', 'Organic non-fat', false, 'Dairy', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
  (1, 'Green Beans', 'half pound', false, 'Produce', CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, category, created_at) values
(2, 'Avocadoes', 'Haas', false, 'Produce', CURRENT_TIMESTAMP())