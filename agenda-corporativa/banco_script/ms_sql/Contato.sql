CREATE TABLE tb_contato (
	con_id int IDENTITY(1,1) primary key NOT NULL,
	con_nome varchar(60),
	con_telefone varchar(50),
	con_email varchar(50),
	con_endereco varchar(100),
	con_ativo bit NOT NULL
);


CREATE TABLE tb_agenda_contato (
	age_con_id int IDENTITY(1,1) primary key NOT NULL,
	con_id int NOT NULL,
	age_id int NOT NULL,

	CONSTRAINT tb_agenda_contato_age_fk 
		FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id),
	CONSTRAINT tb_agenda_contato_con_fk 
		FOREIGN KEY (con_id)
		REFERENCES tb_contato (con_id)
);