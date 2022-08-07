-- user
insert into "user" (id, name, email)
values (100L, 'kendrick', 'kendrick@example.com');

-- order
insert into "order" (id, total_price, time, "user_id")
values (100L, 3000, '2022-08-06T16:02:30', 100L),
       (101L, 5000, '2022-08-07T07:02:30', 100L);

-- item
insert into item (id, name, price)
values (100L, 'popcorn', 1000),
       (101L, 'USB cable', 2000),
       (102L, 'battery', 1500),
       (103L, 'PC stand', 1000);

-- order_detail
insert into order_detail (id, price, quantity, "order_id", item_id)
values (100L, 1000, 1, 100L, 100L),
       (101L, 2000, 1, 100L, 101L),
       (102L, 3000, 2, 101L, 102L),
       (103L, 1000, 1, 101L, 100L),
       (104L, 1000, 1, 101L, 103L);

