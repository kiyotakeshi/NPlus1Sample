-- user
insert into "user" (id, name, email) values (100L, 'kendrick', 'kendrick@example.com');

-- order
insert into "order" (id, total_price, time, "user_id") values (100L, 3000, '2022-08-06T16:02:30', 100L);
insert into "order" (id, total_price, time, "user_id") values (101L, 5000, '2022-08-07T07:02:30', 100L);

-- order_detail
insert into order_detail (id, price, quantity, "order_id") values (100L, 1000, 1, 100L);
insert into order_detail (id, price, quantity, "order_id") values (101L, 2000, 1, 100L);
insert into order_detail (id, price, quantity, "order_id") values (102L, 3000, 2, 101L);
insert into order_detail (id, price, quantity, "order_id") values (103L, 1000, 1, 101L);
insert into order_detail (id, price, quantity, "order_id") values (104L, 1000, 1, 101L);
