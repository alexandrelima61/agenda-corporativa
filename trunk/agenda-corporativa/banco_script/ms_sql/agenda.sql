CREATE TABLE tb_agenda(
	age_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	age_titulo varchar(50) NULL,
	age_descricao varchar(200) NULL,
	age_ativo bit NULL
);


CREATE TABLE tb_agenda_usuario (
	age_usu_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	age_id int NOT NULL,
	usu_id int NOT NULL,

	CONSTRAINT FK_tb_adenda_usuario_age
		FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id),
	CONSTRAINT FK_tb_adenda_usuario_usu
		FOREIGN KEY (usu_id)
		REFERENCES tb_usuario (usu_id)
);