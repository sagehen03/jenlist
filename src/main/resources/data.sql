insert into master_list(name, created_at) values('Tomatoes', CURRENT_TIMESTAMP());
insert into master_list(name, created_at) values('Green Beans', CURRENT_TIMESTAMP());
insert into master_list(name, created_at) values('Dog Treats', CURRENT_TIMESTAMP());
-- insert into master_list(name, created_at) values('Coffee', CURRENT_TIMESTAMP());
-- insert into master_list(name, created_at) values('French Bread', CURRENT_TIMESTAMP());
-- insert into master_list(name, created_at) values('Chicken', CURRENT_TIMESTAMP());
-- insert into master_list(name, created_at) values('Avocadoes', CURRENT_TIMESTAMP());
-- insert into master_list(name, created_at) values('Milk', CURRENT_TIMESTAMP());
insert into shopping_list(name) values('Whole Foods List');

insert into shopping_list_item(shopping_list_id, name, comment, completed, created_at) values
  (1, 'Tomatoes', '3', false, CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, created_at) values
  (1, 'Dog Treats', 'Barkleys Brand', false, CURRENT_TIMESTAMP());
insert into shopping_list_item(shopping_list_id, name, comment, completed, created_at) values
  (1, 'Green Beans', 'half pound', false, CURRENT_TIMESTAMP())