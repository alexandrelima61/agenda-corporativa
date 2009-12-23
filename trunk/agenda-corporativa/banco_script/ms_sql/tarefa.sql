CREATE TABLE tb_tarefa (
	tar_id int IDENTITY(1,1) PRIMARY KEY,
	age_id int,
	tar_titulo varchar(70),
	tar_data datetime,
	tar_local varchar(40),
	tar_prioridade int,
	tar_descricao varchar(250),
	tar_estado int,
	tar_ativo bit NOT NULL,

	CONSTRAINT FK_tb_tarefa_agen
		FOREIGN KEY(age_id) 
		REFERENCES tb_agenda (age_id)
);