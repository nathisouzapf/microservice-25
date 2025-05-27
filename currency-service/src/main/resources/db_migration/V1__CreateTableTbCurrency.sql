CREATE TABLE tb_currency (
	id SERIAL PRIMARY KEY,
	sourc_currency CHAR(3) NOT NULL,
	target_currency CHAR(3) NOT NULL,
	conversion_rate DECIMAL (10,2) NOT NULL
);