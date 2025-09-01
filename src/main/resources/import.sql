-- Sample data for dev and test
insert into category (id, name) values (1, 'Electronics');
insert into category (id, name, parent_id) values (2, 'Phones', 1);
insert into product (id, name) values (1, 'Smartphone');
insert into product_category (product_id, category_id) values (1, 2);
insert into variant (id, name, product_id) values (1, 'Smartphone 128GB', 1);

alter sequence category_seq restart with 3;
alter sequence product_seq restart with 2;
alter sequence variant_seq restart with 2;
