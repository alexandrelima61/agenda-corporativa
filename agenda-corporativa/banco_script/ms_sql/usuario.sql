CREATE TABLE tb_usuario (
	usu_id int IDENTITY(1,1) NOT NULL,
	usu_nome varchar(60) NULL,
	usu_login varchar(30) NULL,
	usu_senha varchar(30) NULL,
	usu_ativo bit NULL,

	CONSTRAINT PK_tb_usuario PRIMARY KEY (usu_id) 
);
