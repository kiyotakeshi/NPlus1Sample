-- user
insert into "user" (id, name, email)
values (100, 'kendrick', 'kendrick@example.com'),
       (101, 'kanye', 'kanye@example.com'),
       (102, 'mike', 'mike@example.com');

-- order
insert into "order" (id, total_price, time, "user_id")
values (100, 3000, '2022-08-06T16:02:30', 100),
       (101, 5000, '2022-08-07T07:02:30', 100),
       (102, 2000, '2022-08-07T23:02:30', 101),
       (103, 5500, '2022-08-07T23:14:30', 102);

-- item
insert into item (id, name, price)
values (100, 'popcorn', 1000),
       (101, 'USB cable', 2000),
       (102, 'battery', 1500),
       (103, 'PC stand', 1000);

-- order_detail
insert into order_detail (id, price, quantity, "order_id", item_id)
values (100, 1000, 1, 100, 100),
       (101, 2000, 1, 100, 101),
       (102, 3000, 2, 101, 102),
       (103, 1000, 1, 101, 100),
       (104, 1000, 1, 101, 103),
       (105, 2000, 1, 102, 101),
       (106, 1000, 1, 103, 100),
       (107, 2000, 1, 103, 101),
       (108, 1500, 1, 103, 102),
       (109, 1000, 1, 103, 103);
