-- user
insert into "user" (id, name, email) values (100L, 'kendrick', 'kendrick@example.com');

-- order
insert into "order" (id, total_price, time, "user_id") values (100L, 3000, '2022-08-06T16:02:30', 100L);
insert into "order" (id, total_price, time, "user_id") values (101L, 5000, '2022-08-07T07:02:30', 100L);
