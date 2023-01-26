insert into users
	VALUES ('1', 'admin', 'admin', 111, 'admin', '$2a$12$DuPC0PKn/2CzBk/9vmjAheqZHUqKkx3TeBgJX0zVE0JRuJnSy4LPm');

insert into role
	VALUES ('1', 'USER'),
	('2', 'ADMIN');

insert into users_roles (
	user_id, role_id)
	VALUES ('1', '1'),
	('1', '2');
