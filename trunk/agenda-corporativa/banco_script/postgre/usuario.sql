CREATE TABLE tb_usuario (
  usu_id serial NOT NULL,
  usu_nome character varying(60),
  usu_login character varying(30),
  usu_senha character varying(30),
  usu_ativado boolean,
  
  CONSTRAINT tb_usuario_pk PRIMARY KEY (usu_id)  
);