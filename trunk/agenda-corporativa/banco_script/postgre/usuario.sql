CREATE TABLE tb_usuario
(
  usu_id serial NOT NULL,
  usu_nome character varying(60),
  usu_login character varying(20),
  CONSTRAINT pk_usu_id PRIMARY KEY (usu_id)
)