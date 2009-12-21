CREATE TABLE tb_tarefa (
  tar_id serial NOT NULL,
  age_id serial NOT NULL,
  usu_id serial NOT NULL,
  tar_titulo character varying(25),
  tar_data timestamp,
  tar_local character varying(40),
  tar_prioridade integer,
  tar_descricao character varying(250),
  tar_estado integer,
  tar_ativado boolean NOT NULL,
  CONSTRAINT pk_tar_id PRIMARY KEY (tar_id),
  FOREIGN KEY(age_id) REFERENCES tb_agenda(age_id),
  FOREIGN KEY(usu_id) REFERENCES tb_usuario(usu_id)
) 