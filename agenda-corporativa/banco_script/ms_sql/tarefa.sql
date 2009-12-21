CREATE TABLE tb_tarefa (
	tar_id int IDENTITY(1,1) PRIMARY KEY,
	age_id int,
	usu_id int,
	tar_titulo varchar(25),
	tar_data datetime,
	tar_local varchar(40),
	tar_prioridade int,
	tar_descricao varchar(250),
	tar_estado int,
	tar_ativado bit NOT NULL,
	FOREIGN KEY(age_id) REFERENCES tb_agenda (age_id),
	FOREIGN KEY(usu_id) REFERENCES tb_usuario (usu_id)
)