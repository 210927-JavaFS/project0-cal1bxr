CREATE TABLE users (
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	user_name VARCHAR(50) PRIMARY KEY,
	user_password VARCHAR(100),
	roles VARCHAR(50),
	account_active BOOLEAN DEFAULT FALSE
);

CREATE TABLE accounts (
	user_name VARCHAR(50) REFERENCES users (user_name),
	account_number VARCHAR(10) PRIMARY KEY
);

CREATE TABLE account_balances (
	user_name VARCHAR(50) REFERENCES users (user_name),
	account_number VARCHAR(10) PRIMARY KEY,
	account_balances FLOAT
);

INSERT
	INTO
	users (first_name,
	last_name,
	user_name,
	user_password,
	roles,
	account_active)
VALUES (
	'Matt',
	'Jordan',
	'mjordan',
	'Password1',
	'roles',
	TRUE)
	;
	

INSERT INTO account_balances (user_name, account_number, account_balances) VALUES ('mjordan', '138297266', '0.00')