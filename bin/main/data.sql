insert into user (user_id, name, username, password)
values(1, 'Gabrie Oest', 'gabrieloest', '12345678');

insert into tweet (tweet_id, date, user_id, title, message)
values(1, TIMESTAMP '2018-04-23 00:00:00', 1, 'Title 1 User 1', 'Text message to test tweet 1 User 1');

insert into tweet (tweet_id, date, user_id, title, message)
values(2, TIMESTAMP '2018-04-23 10:00:00', 1, 'Title 2 User 1', 'Text message to test tweet 2 User 1');

insert into tweet (tweet_id, date, user_id, title, message)
values(3, TIMESTAMP '2018-04-21 00:00:00', 1, 'Title 3 User 1', 'Text message to test tweet 3 User 1');

insert into user (user_id, name, username, password)
values(2, 'John Doe', 'johndoe', '87654321');

insert into tweet (tweet_id, date, user_id, title, message)
values(4, TIMESTAMP '2018-04-21 00:00:00', 2, 'Title 1 User 2', 'Text message to test tweet 1 User 2');