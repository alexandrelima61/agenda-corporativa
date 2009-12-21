CREATE TABLE tb_usuario
(
  usu_id int IDENTITY(1,1) NOT NULL,
  usu_nome varchar(60),
  usu_login varchar(30),
  usu_senha varchar(30),
  usu_ativado bit,
  CONSTRAINT pk_usu_id PRIMARY KEY (usu_id)  
)